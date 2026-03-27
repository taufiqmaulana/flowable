package dev.mcoder.boot.flowable.model;

import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
public class FlowDefinition {
    private String version;
    private String name;
    private String description;
    private List<String> fields;
    private List<String> groups;
    private List<FlowHook> hooks;
    private Map<String, FlowStatus> flows;
}
