package configurator.test.resources.json.file;

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

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonArrayFileOkDefFieldNameOk

// Ok file name with default value class member field name ok
@Path("/config")
public class JA_FileOk_DefFld_NameOk {
	
	JsonArray ja = Json.createArrayBuilder().add("Default Value Field").build();
	
	@Inject
	@ConfigJson(filePath = "/config/configArray.json", defaultValueIsClassMember = "ja")
	private TypedProperty<JsonArray> test;
	
	
	@Path("/jsonArrayFileOkDefFieldNameOk")
	@GET
	public Response testGet() {
		return Response.ok("Ok file name with default value class member field name ok: " + test).build();
	}
	
	@Path("/jsonArrayFileOkDefFieldNameOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonArray> testGetTest() {
		return test;
	}
}