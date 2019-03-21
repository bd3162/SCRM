package com.seu.scrm.Controller.Rest.Marketing;

import com.seu.scrm.Service.MarketingService;
import com.seu.scrm.dto.CaptureNotify;
import com.seu.scrm.dto.PersonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chenxiaosuo on 2019/3/19.
 */
@CrossOrigin
@RestController
public class MarketingController {
    @Autowired
    private MarketingService marketingService;

    @RequestMapping(value = "/rest/marketing/notify", method = RequestMethod.POST)
    public String queryPersonStatistics(@RequestBody CaptureNotify captureNotify){
        return marketingService.handleCaptureNotify(captureNotify);
    }

    @RequestMapping(value = "/rest/marketing/queryRecommendation", method = RequestMethod.GET)
    public String queryPersonRecommendation(@RequestParam(name = "salesManId") String salesManId){
        return marketingService.queryRecommendation(salesManId);
    }
}
