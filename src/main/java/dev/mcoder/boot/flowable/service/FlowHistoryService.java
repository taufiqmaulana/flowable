package dev.mcoder.boot.flowable.service;

import dev.mcoder.boot.flowable.model.ValidAction;

public interface FlowHistoryService {

    void record(String flowableId, String flow, String from, String to, ValidAction action, String actor);

}
