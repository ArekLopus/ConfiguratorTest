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
// curl -i http://localhost:8080/ConfiguratorTest/res/config/PropGlobalRuntimeYesLocalRuntimeUseGl

// Change runtime first to set proper runtime check
// Ok json object from property file, global runtime check YES, local runtime check USE GLOBAL (always reloads)
@Path("/config")
public class Prop_GlobalRtYes_LocalRtUseGl {
	
	@Inject
	@ConfigJson(property = "jsonObjectProp", runtimeCheck = RuntimeCheckType.USE_GLOBAL)
	private TypedProperty<JsonObject> test;
	
	
	@Path("/PropGlobalRuntimeYesLocalRuntimeUseGl")
	@GET
	public Response testGet() {
		return Response.ok("Ok json object from property file, global runtime check YES, local runtime check USE GLOBAL (always reloads): " + test).build();
	}
	
	@Path("/PropGlobalRuntimeYesLocalRuntimeUseGl/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
}