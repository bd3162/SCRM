package com.seu.scrm.Controller.minProgram;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.net.URL;
import java.net.URLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/openId")
public class OpenIdController {
    private String openid=null;
    private String appid = "wxbb51c2905feaeb14";
    //private String secretKey = "76ee3a1fe59ee5cde1331a3f79813a88";
    private String secretKey = "20b95fda97e91d765908fb154a5dfeeb";

    @RequestMapping(value = "/getId")//小程序test4
    public HashMap<String,Object> doPost(@RequestParam String code, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("doPost--------------------");
        // 获取操作类型，根据类型执行不同操作
        //String operFlag = request.getParameter("operFlag");
        //System.out.println("operFlag"+operFlag);
        String results = "";
        //if ("getOpenid".equals(operFlag)) {
        String codes= request.getParameter("code");
        System.out.println("request.getParameter(code):"+codes);//拿到微信小程序传过来的code
        System.out.println("@RequestParam String code"+code);
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secretKey
                + "&js_code=" + code + "&grant_type=authorization_code";   //接口地址
        System.out.println("url"+url);
        results = sendGetReq(url);// 发送http请求
        System.out.println("results:"+results);
        String [] temps=results.split("\"openid\":\"");
        System.out.println("截取后temps: "+temps[1]);
        String [] temps1=temps[1].split("\"");
        System.out.println("temps1: "+temps1[0]);
        HashMap<String,Object> map=new HashMap<>();
        openid=temps1[0];
        map.put("openid",openid);
        return map;
       /* str=temps1[0];
        XiaoChengXu xiaoChengXu =new XiaoChengXu();
        xiaoChengXu.setOpenId(str);
        xiaoChengXuService.insertXiaoChengXu(xiaoChengXu);*/

        /*response.setContentType("application/json;charset=UTF-8");
        response.setHeader("catch-control", "no-catch");
        PrintWriter out = response.getWriter();
        out.write(results);
        out.flush();
        out.close();*/
    }

    private String sendGetReq(String url) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            java.util.Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        } // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
}
