package com.seu.scrm.Controller.Rest.Report;

import com.seu.scrm.dto.PersonRequest;
import com.seu.scrm.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chenxiaosuo on 2019/3/6.
 */

@RestController
public class ReportController {
    @Autowired
    private ReportService reportService;


    @RequestMapping(value = "/rest/report", method = RequestMethod.POST)
    public String queryPersonStatistics(@RequestBody PersonRequest personRequest){
        return reportService.queryReport(personRequest);
    }

}
