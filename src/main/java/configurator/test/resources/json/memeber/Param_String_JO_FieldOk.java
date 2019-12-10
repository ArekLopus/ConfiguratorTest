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

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectMemberFieldParemeterStringNameOk

// Parameterized type String, field name ok
@Path("/config")
public class Param_String_JO_FieldOk {
	
	JsonObject jo = Json.createObjectBuilder().add("objFieldKey1", "objFieldVal1").add("objFieldKey2", "objFieldVal2").build();
	
	@Inject
	@ConfigJson(classMember = "jo")
	private TypedProperty<String> test;
	
	
	@Path("/jsonObjectMemberFieldParemeterStringNameOk")
	@GET
	public Response testGet() {
		return Response.ok("Parameterized type String, field name ok: " + test).build();
	}
	
	@Path("/jsonObjectMemberFieldParemeterStringNameOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<String> testGetTest() {
		return test;
	}
}