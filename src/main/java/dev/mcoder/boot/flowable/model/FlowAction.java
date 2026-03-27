package dev.mcoder.boot.flowable.model;

import lombok.Data;
import java.util.List;

@Data
public class FlowAction {
    private String label;
    private String target;
    private List<String> authorities;
}
