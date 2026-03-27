package dev.mcoder.boot.flowable.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Status {

    private String flow;
    private String status;
    private Map<String, String> attributes;

}
