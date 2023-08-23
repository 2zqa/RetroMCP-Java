package org.mcphackers.mcp.tasks;

import org.mcphackers.mcp.MCP;
import org.mcphackers.mcp.tools.mappings.MappingUtil;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TaskMergeMappings extends TaskStaged {
	public TaskMergeMappings(MCP instance) {
		super(instance);
	}

	@Override
	protected Stage[] setStages() {
		return new Stage[] {
				stage(getLocalizedStage("mergemappings"), () -> {
					Path clientMappings = Paths.get("client.tiny");
					Path serverMappings = Paths.get("server.tiny");
					Path mergedMappings = Paths.get("merged.tiny");
					if (Files.exists(clientMappings)) {
						if (Files.exists(serverMappings)) {
							// Merge client & server mappings
							MappingUtil.mergeMappings(clientMappings, serverMappings, mergedMappings);
						} else {
							// Only client mappings exist
							MappingUtil.mergeMappings(clientMappings, mergedMappings);
						}
					}
				})
		};
	}
}
