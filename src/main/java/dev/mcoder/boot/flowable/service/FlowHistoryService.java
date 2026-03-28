package dev.mcoder.boot.flowable.service;

import dev.mcoder.boot.flowable.contract.FlowActor;
import dev.mcoder.boot.flowable.contract.Flowable;
import dev.mcoder.boot.flowable.model.FlowHistory;
import dev.mcoder.boot.flowable.model.ValidAction;

import java.util.List;

public interface FlowHistoryService {

    void record(Flowable flowable, FlowActor actor, String from, String to, ValidAction action, String notes);

    List<FlowHistory> loadHistory(Flowable flowable);

}
