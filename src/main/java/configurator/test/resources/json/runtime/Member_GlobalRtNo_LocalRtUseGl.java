package configurator.test.resources.json.runtime;

import javax.inject.Inject;
import javax.json.Json;
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
// curl -i http://localhost:8080/ConfiguratorTest/res/config/MemberGlobalRuntimeNoLocalRuntimeUseGl

// Change runtime first to set proper runtime check
// Ok json object from member, global runtime check NO, local runtime check USE GLOBAL (never reloads if already in properties)
@Path("/config")
public class Member_GlobalRtNo_LocalRtUseGl {
	
	@Inject
	@ConfigJson(classMember = "jom", runtimeCheck = RuntimeCheckType.USE_GLOBAL)
	private TypedProperty<JsonObject> test;
	
	
	@Path("/MemberGlobalRuntimeNoLocalRuntimeUseGl")
	@GET
	public Response testGet() {
		return Response.ok("Ok json object from member, global runtime check NO, local runtime check USE GLOBAL (never reloads if already in properties): " + test).build();
	}
	
	@Path("/MemberGlobalRuntimeNoLocalRuntimeUseGl/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
	
	public JsonObject jom() {
		return Json.createObjectBuilder().add("objMethodKey1", "objMethodVal1").add("objMethodKey2", "objMethodVal2").build();
	}
	
}