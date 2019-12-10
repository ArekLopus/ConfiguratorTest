package configurator.test.resources.json.url;

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

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectUrlOkDefValMethodNameOk

// Ok URL with default value class member method name ok
@Path("/config")
public class JO_UrlOk_DefMtd_NameOk {
	
	JsonObject jo = Json.createObjectBuilder().add("error", "Field - There was an error loading value.").build();
	
	@Inject
	@ConfigJson(url = "http://localhost:8080/ConfiguratorTest/res/json/object", defaultValueIsClassMember = "jom")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/jsonObjectUrlOkDefValMethodNameOk")
	@GET
	public Response testGet() {
		return Response.ok("Ok URL with default value class member method name ok: " + test).build();
	}
	
	@Path("/jsonObjectUrlOkDefValMethodNameOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
	
	public JsonObject jom() {
		return Json.createObjectBuilder().add("error", "Method - There was an error loading value.").build();
	}
}