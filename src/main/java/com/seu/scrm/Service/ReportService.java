package com.seu.scrm.Service;

import com.seu.scrm.dto.HotRequest;
import com.seu.scrm.dto.PersonRequest;
import com.seu.scrm.dto.QuarterlyRequest;

/**
 * Created by chenxiaosuo on 2019/3/5.
 */
public interface ReportService {

    String queryPersonReport(PersonRequest request);

    String queryHotReport(HotRequest request);

    String queryQuarterlyReport(QuarterlyRequest request);
}
