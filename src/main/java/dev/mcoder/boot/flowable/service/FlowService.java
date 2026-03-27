package dev.mcoder.boot.flowable.service;

import dev.mcoder.boot.flowable.dto.Action;
import dev.mcoder.boot.flowable.dto.Status;

import java.util.Set;

public interface FlowService {

    Status start(String flowableId, String flow, String actor);

    Status next(String flowableId, String flow, String status, String actor);

    Status back(String flowableId, String flow, String status, String actor);

    Status alternate(String flowableId, String flow, String status, String actor);

    Set<Action> actions(String flow, String status, String actor);




}
