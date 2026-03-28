package dev.mcoder.boot.flowable.service;

import dev.mcoder.boot.flowable.contract.FlowActor;
import dev.mcoder.boot.flowable.contract.Flowable;
import dev.mcoder.boot.flowable.dto.Action;
import dev.mcoder.boot.flowable.dto.Status;

import java.util.Set;

public interface FlowService {

    Status start(Flowable flowable, String flow, FlowActor actor, String notes);

    Status forward(Flowable flowable, FlowActor actor, String notes);

    Status backward(Flowable flowable, FlowActor actor, String notes);

    Status alternative(Flowable flowable, FlowActor actor, String notes);

    Set<Action> actions(Flowable flowable, FlowActor actor);

}
