package configurator.test.resources.json.memeber;

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

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectMethodObjNameOk

// Method class member object name ok
@Path("/config")
public class JO_MethodOk_ObjOk {
	
	@Inject
	@ConfigJson(classMember = "jom")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/jsonObjectMethodObjNameOk")
	@GET
	public Response testGet() {
		return Response.ok("Method class member object name ok: " + test).build();
	}
	
	@Path("/jsonObjectMethodObjNameOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
	
	public JsonObject jom() {
		return Json.createObjectBuilder().add("objMethodKey1", "objMethodVal1").add("objMethodKey2", "objMethodVal2").build();
	}
	
}