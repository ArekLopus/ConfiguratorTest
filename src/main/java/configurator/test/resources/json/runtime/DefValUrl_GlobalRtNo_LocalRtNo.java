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

// curl -i http://localhost:8080/ConfiguratorTest/res/config/changeRuntime/false
// curl -i http://localhost:8080/ConfiguratorTest/res/config/DefValUrlGlobalRuntimeNoLocalRuntimeNo
// curl -i http://localhost:8080/ConfiguratorTest/res/json/changeObjectDefVal

// Change runtime first to set proper runtime check
// Ok json object from Url, global runtime check NO, local runtime check NO (never reloads if already in properites)
@Path("/config")
public class DefValUrl_GlobalRtNo_LocalRtNo {
	
	@Inject
	@ConfigJson(defaultValueUrl = "http://localhost:8080/ConfiguratorTest/res/json/objectDefVal", runtimeCheck = RuntimeCheckType.NO)
	private TypedProperty<JsonObject> test;
	
	
	@Path("/DefValUrlGlobalRuntimeNoLocalRuntimeNo")
	@GET
	public Response testGet() {
		return Response.ok("Ok json object from Url, global runtime check NO, local runtime check NO (never reloads if already in properites): " + test).build();
	}
	
	@Path("/DefValUrlGlobalRuntimeNoLocalRuntimeNo/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
}