package configurator.test.resources.json.runtime;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;
import configurator.enums.RuntimeCheckType;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/changeRuntime/true
// curl -i http://localhost:8080/ConfiguratorTest/res/config/FileGlobalRuntimeYesLocalRuntimeYes

// Change runtime first to set proper runtime check
// Ok json object from file, global runtime check YES, local runtime check YES (always reloads)
@Path("/config")
public class File_GlobalRtYes_LocalRtYes {
	
	@Inject
	@ConfigJson(filePath = "/config/configObject.json", runtimeCheck = RuntimeCheckType.YES)
	private TypedProperty<JsonObject> test;
	
	
	@Path("/FileGlobalRuntimeYesLocalRuntimeYes")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response testGet() {
		return Response.ok("Ok json object from file, global runtime check YES, local runtime check YES (always reloads): " + test).build();
	}
	
	@Path("/FileGlobalRuntimeYesLocalRuntimeYes/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
}