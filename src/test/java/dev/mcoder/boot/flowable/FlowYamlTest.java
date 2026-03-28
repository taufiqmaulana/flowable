package dev.mcoder.boot.flowable;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import dev.mcoder.boot.flowable.model.SchemaFlowDefinition;
import dev.mcoder.boot.flowable.model.ValidAction;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

class FlowYamlTest {

    @Test
    void testParseYaml() throws Exception {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        SchemaFlowDefinition flowDefinition = mapper.readValue(new File("flow.yaml"), SchemaFlowDefinition.class);

        assertNotNull(flowDefinition);
        assertEquals("1.0", flowDefinition.getVersion());
        assertEquals("Sample", flowDefinition.getName());
        assertEquals(3, flowDefinition.getFields().size());
        assertEquals(3, flowDefinition.getGroups().size());
        assertEquals(2, flowDefinition.getHooks().size());
        assertEquals(2, flowDefinition.getFlows().size());

        // Test first flow fl-001
        var flow1 = flowDefinition.getFlows().get("fl-001");
        assertNotNull(flow1);
        assertEquals("Draft", flow1.getName());
        assertEquals("Submit", flow1.getAction().get(ValidAction.next).getLabel());
        
        // Test second flow fl-002
        var flow2 = flowDefinition.getFlows().get("fl-002");
        assertNotNull(flow2);
        assertEquals("Review", flow2.getName());
        assertEquals("Approve", flow2.getAction().get(ValidAction.next).getLabel());
        assertEquals("Return", flow2.getAction().get(ValidAction.prev).getLabel());
        assertEquals("Request Change", flow2.getAction().get(ValidAction.altr).getLabel());
    }
}
