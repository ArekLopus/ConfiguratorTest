package configurator.test.resources.json.url;

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

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonArrayUrlOkDefFieldNameOk

// Ok URL with default value class member field name ok
@Path("/config")
public class JA_UrlOk_DefFld_NameOk {
	
	JsonArray ja = Json.createArrayBuilder().add("Field Default Value").build();
	
	@Inject
	@ConfigJson(url = "http://localhost:8080/ConfiguratorTest/res/json/array", defaultValueIsClassMember = "ja")
	private TypedProperty<JsonArray> test;
	
	
	@Path("/jsonArrayUrlOkDefFieldNameOk")
	@GET
	public Response testGet() {
		return Response.ok("Ok URL with default value class member field name ok: " + test).build();
	}
	
	@Path("/jsonArrayUrlOkDefFieldNameOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonArray> testGetTest() {
		return test;
	}
}