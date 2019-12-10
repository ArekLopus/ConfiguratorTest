package configurator.test.resources.json.memeber;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonArrayMethodObjNameOk

// Method class member array object name ok
@Path("/config")
public class JA_MethodOk_ObjOk {
	
	@Inject
	@ConfigJson(classMember = "jam")
	private TypedProperty<JsonArray> test;
	
	
	@Path("/jsonArrayMethodObjNameOk")
	@GET
	public Response testGet() {
		return Response.ok("Method class member array object name ok: " + test).build();
	}
	
	@Path("/jsonArrayMethodObjNameOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonArray> testGetTest() {
		return test;
	}
	
	public JsonArray jam() {
		return Json.createArrayBuilder().add("arrObjMetVal1").add("arrObjMetVal2").build();
	}
	
}