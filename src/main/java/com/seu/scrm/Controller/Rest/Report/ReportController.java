package com.seu.scrm.Controller.Rest.Report;

import com.seu.scrm.dto.HotRequest;
import com.seu.scrm.dto.PersonRequest;
import com.seu.scrm.dto.QuarterlyRequest;
import com.seu.scrm.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by chenxiaosuo on 2019/3/6.
 */

@RestController
public class ReportController {
    @Autowired
    private ReportService reportService;

    private final static Logger logger = LoggerFactory.getLogger(ReportController.class);

    @RequestMapping(value = "/rest/report/person", method = RequestMethod.POST)
    public String queryPersonStatistics(@RequestBody PersonRequest personRequest){
        return reportService.queryPersonReport(personRequest);
    }

    @RequestMapping(value = "/rest/report/hot", method = RequestMethod.POST)
    public String queryHotStatistics(@RequestBody HotRequest request){
        return reportService.queryHotReport(request);
    }

    @RequestMapping(value = "/rest/report/quarterly", method = RequestMethod.POST)
    public String queryQuarterlyStatistics(@RequestBody QuarterlyRequest request){
        return reportService.queryQuarterlyReport(request);
    }

}
