package com.jobsedule.report.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@Data
@ConfigurationProperties(prefix = "cpb.psd2")
public class ReportProperties {

    private SplunkProperties splunkProperties;
}
