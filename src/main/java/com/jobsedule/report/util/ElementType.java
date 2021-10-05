package com.jobsedule.report.util;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ElementType {
    private Map<String, List<String>> consent;
    private Map<String, List<String>> resource;
    private Map<String, List<String>> others;
    /*private List<String> consent;
    private List<String> resource;
    private List<String> others;*/
}
