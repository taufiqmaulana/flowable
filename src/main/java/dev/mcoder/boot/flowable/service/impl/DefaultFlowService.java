package dev.mcoder.boot.flowable.service.impl;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import dev.mcoder.boot.flowable.contract.FlowActor;
import dev.mcoder.boot.flowable.contract.Flowable;
import dev.mcoder.boot.flowable.dto.Action;
import dev.mcoder.boot.flowable.dto.Status;
import dev.mcoder.boot.flowable.model.SchemaFlowDefinition;
import dev.mcoder.boot.flowable.service.FlowService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

@Slf4j
@Service
public class DefaultFlowService implements FlowService {

    private final String schemaDirectory;
    private final Map<String, SchemaFlowDefinition> schemas = new HashMap<>();

    public DefaultFlowService(
            @Value("${mcoder.flowable.schema.directory}")
            String schemaDirectory
    ) {
        this.schemaDirectory = schemaDirectory;
    }

    @PostConstruct
    void init() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Path path = Paths.get(schemaDirectory);
        try (Stream<Path> paths = Files.list(path)) {
            paths.map(Path::toFile)
                    .filter(file -> !file.isDirectory() && (file.getName().endsWith(".yaml") || file.getName().endsWith(".yml")))
                    .forEach(file -> {
                        String name = file.getName();
                        try {
                            String schemaName = name.substring(0, name.lastIndexOf(".")).replace(" ", "");
                            SchemaFlowDefinition schema = mapper.readValue(file, SchemaFlowDefinition.class);
                            schemas.put(schemaName, schema);
                        } catch (IOException e) {
                            log.error("Unable to read schema from file : {}", name, e);
                        }
                    });
        }

        if (schemas.isEmpty()) {
            log.warn("No schema definition available");
        } else {
            log.info("Loaded {} schemas", schemas.size());
        }

    }

    @Override
    public Status start(Flowable flowable, String flow, FlowActor actor, String notes) {
        return null;
    }

    @Override
    public Status forward(Flowable flowable, FlowActor actor, String notes) {
        return null;
    }

    @Override
    public Status backward(Flowable flowable, FlowActor actor, String notes) {
        return null;
    }

    @Override
    public Status alternative(Flowable flowable, FlowActor actor, String notes) {
        return null;
    }

    @Override
    public Set<Action> actions(Flowable flowable, FlowActor actor) {
        return Set.of();
    }
}
