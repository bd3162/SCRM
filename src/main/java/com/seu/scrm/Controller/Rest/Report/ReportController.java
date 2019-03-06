package com.seu.scrm.Controller.Rest.Report;

import com.seu.scrm.dto.PersonRequest;
import com.seu.scrm.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by chenxiaosuo on 2019/3/6.
 */

@RestController
public class ReportController {
    @Autowired
    private ReportService reportService;

    @RequestMapping(value = "/rest/report", method = RequestMethod.POST)
    public String queryPersonStatistics(PersonRequest personRequest){

        return personRequest.toString();
    }

}
