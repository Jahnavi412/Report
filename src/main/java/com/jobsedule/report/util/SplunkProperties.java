package com.jobsedule.report.util;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class SplunkProperties {

    private List<String> source;
    /*private Api api;*/
    private Map<String, String> api;
    private List<String> method;
    private ElementType type;
}
