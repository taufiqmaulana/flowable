package dev.mcoder.boot.flowable.dto;

import dev.mcoder.boot.flowable.model.ValidAction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Action {

    private ValidAction action;
    private String label;

}
