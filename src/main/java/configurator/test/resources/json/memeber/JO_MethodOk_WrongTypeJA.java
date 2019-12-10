package configurator.test.resources.json.memeber;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectMethodOkWrongReturnTypeJA

// Method class member method name ok return type bad (JA)
@Path("/config")
public class JO_MethodOk_WrongTypeJA {
	
	String jos = "{\"strFieldKey1\" : \"strFieldVal1\", \"strFieldKey2\": \"strFieldVa2\"}";
	
	@Inject
	@ConfigJson(classMember = "jom")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/jsonObjectMethodOkWrongReturnTypeJA")
	@GET
	public Response testGet() {
		return Response.ok("Method class member method name ok return type bad (JA): " + test).build();
	}
	
	@Path("/jsonObjectMethodOkWrongReturnTypeJA/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
	
	public JsonArray jom() {
		return Json.createArrayBuilder().add("Field Default Value").build();
	}
	
}