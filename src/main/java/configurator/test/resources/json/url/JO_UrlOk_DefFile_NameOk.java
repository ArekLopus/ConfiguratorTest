package configurator.test.resources.json.url;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectUrlOkDefValFileNameOk

// Ok URL with default value file name ok
@Path("/config")
public class JO_UrlOk_DefFile_NameOk {
	
	
	@Inject
	@ConfigJson(url = "http://localhost:8080/ConfiguratorTest/res/json/object", defaultValueFile = "/config/configObjectDefVal.json")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/jsonObjectUrlOkDefValFileNameOk")
	@GET
	public Response testGet() {
		return Response.ok("Ok URL with default value file name ok: " + test).build();
	}
	
	@Path("/jsonObjectUrlOkDefValFileNameOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
}