package com.seu.scrm.service;

import com.seu.scrm.dto.PersonRequest;

/**
 * Created by chenxiaosuo on 2019/3/5.
 */
public interface ReportService {

    String queryReport(PersonRequest request);
}