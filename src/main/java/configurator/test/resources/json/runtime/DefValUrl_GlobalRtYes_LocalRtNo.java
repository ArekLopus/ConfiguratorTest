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
// curl -i http://localhost:8080/ConfiguratorTest/res/config/DefValUrlGlobalRuntimeYesLocalRuntimeNo
// curl -i http://localhost:8080/ConfiguratorTest/res/json/changeObjectDefVal

// Change runtime first to set proper runtime check
// Ok json object from Url, global runtime check YES, local runtime check NO (never reloads if already in properties)
@Path("/config")
public class DefValUrl_GlobalRtYes_LocalRtNo {
	
	@Inject
	@ConfigJson(defaultValueUrl = "http://localhost:8080/ConfiguratorTest/res/json/objectDefVal", runtimeCheck = RuntimeCheckType.NO)
	private TypedProperty<JsonObject> test;
	
	
	@Path("/DefValUrlGlobalRuntimeYesLocalRuntimeNo")
	@GET
	public Response testGet() {
		return Response.ok("Ok json object from Url, global runtime check YES, local runtime check NO (never reloads if already in properties): " + test).build();
	}
	
	@Path("/DefValUrlGlobalRuntimeYesLocalRuntimeNo/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
}