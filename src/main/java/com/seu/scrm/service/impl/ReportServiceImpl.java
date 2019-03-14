package com.seu.scrm.Service.impl;

import com.seu.scrm.dto.PersonRequest;
import com.seu.scrm.Service.ReportService;
import org.springframework.stereotype.Service;

/**
 * Created by chenxiaosuo on 2019/3/5.
 */
@Service(value = "ReportService")
public class ReportServiceImpl implements ReportService {

    @Override
    public String queryReport(PersonRequest request) {
        return request.toString();
    }
}
