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

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectUrlOkDefValFieldNameOk

// Ok URL with default value class member field name ok
@Path("/config")
public class JO_UrlOk_DefFld_NameOk {
	
	JsonObject jo = Json.createObjectBuilder().add("error", "Field - There was an error loading value.").build();
	
	@Inject
	@ConfigJson(url = "http://localhost:8080/ConfiguratorTest/res/json/object", defaultValueIsClassMember = "jo")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/jsonObjectUrlOkDefValFieldNameOk")
	@GET
	public Response testGet() {
		return Response.ok("Ok URL with default value class member field name ok: " + test).build();
	}
	
	@Path("/jsonObjectUrlOkDefValFieldNameOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
}