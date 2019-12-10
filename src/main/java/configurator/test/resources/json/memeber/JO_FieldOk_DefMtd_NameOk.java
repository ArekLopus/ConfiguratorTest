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

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectClassMemberFieldOkDefMethodNameOk

// Ok class member field name with default value class member method name ok
@Path("/config")
public class JO_FieldOk_DefMtd_NameOk {
	
	JsonObject jo = Json.createObjectBuilder().add("objFieldKey1", "objFieldVal1").add("objFieldKey2", "objFieldVal2").build();
	
	@Inject
	@ConfigJson(classMember = "jo", defaultValueIsClassMember = "jom")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/jsonObjectClassMemberFieldOkDefMethodNameOk")
	@GET
	public Response testGet() {
		return Response.ok("Ok class member field name with default value class member method name ok: " + test).build();
	}
	
	@Path("/jsonObjectClassMemberFieldOkDefMethodNameOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
	
	public JsonObject jom() {
		return Json.createObjectBuilder().add("error", "Method - There was an error loading value.").build();
	}
}