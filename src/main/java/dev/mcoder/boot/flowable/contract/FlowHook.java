package dev.mcoder.boot.flowable.contract;

import dev.mcoder.boot.flowable.FlowInterruptedException;
import dev.mcoder.boot.flowable.model.SchemaFlowDefinition;
import dev.mcoder.boot.flowable.model.SchemaFlowStatus;

public interface FlowHook {


    /**
     * Hook called when a flow is executed.
     * @param flow Flow definition
     * @param before Flow status before action
     * @param after Flow status after action
     * <br>
     * When the hook is called before status update (type: before), throw a {@link FlowInterruptedException} to interrupt the flow.
     */
    void onFlow(SchemaFlowDefinition flow, SchemaFlowStatus before, SchemaFlowStatus after) throws FlowInterruptedException;

}
