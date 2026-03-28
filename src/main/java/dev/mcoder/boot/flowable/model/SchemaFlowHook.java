package dev.mcoder.boot.flowable.model;

import lombok.Data;
import java.util.List;

@Data
public class SchemaFlowHook {
    private String type;
    private String bean;
    private List<String> onAction;
}
