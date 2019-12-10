package configurator.test.resources.json.defval;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.ConfiguratorSettings;
import configurator.TypedProperty;
import configurator.annotations.ConfigJson;
import configurator.enums.RuntimeCheckType;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/changeRuntime/true
// curl -i http://localhost:8080/ConfiguratorTest/res/config/PropBothGlobalRuntimeYesLocalRuntimeUseGl

// Change runtime first to set proper runtime check
// Ok json object from property file, global runtime check YES, local runtime check USE GLOBAL (always reloads)
// To check if properties are not reloaded twice - 1 reload here
@Path("/config")
public class Reload_PropOk_GlobalRtYes_LocalRtUseGl {
	
	@Inject
	@ConfigJson(property = "jsonObjectProp", defaultValueProperty = "jsonObjectDefValProp", runtimeCheck = RuntimeCheckType.USE_GLOBAL)
	private TypedProperty<JsonObject> test;
	
	
	@Path("/PropBothGlobalRuntimeYesLocalRuntimeUseGl")
	@GET
	public Response testGet() {
		return Response.ok("To check if properties are not reloaded twice - 1 reload here: " + test).build();
	}
	
	@Path("/PropBothGlobalRuntimeYesLocalRuntimeUseGl/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		ConfiguratorSettings.getInstance().setRuntimeCheck(true);
		return test;
	}
}