package dev.mcoder.boot.flowable.model;

import lombok.Data;
import java.util.Map;

@Data
public class SchemaFlowStatus {
    private String name;
    private String description;
    private Map<ValidAction, SchemaFlowAction> action;
    private Map<String, String> access;
    private Map<String, String> attributes;
}
