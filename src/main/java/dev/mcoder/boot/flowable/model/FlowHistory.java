package dev.mcoder.boot.flowable.model;

import java.time.LocalDateTime;

public record FlowHistory(
        String flow,
        String from,
        String to,
        ValidAction action,
        String actor,
        String notes,
        LocalDateTime createdAt
) { }
