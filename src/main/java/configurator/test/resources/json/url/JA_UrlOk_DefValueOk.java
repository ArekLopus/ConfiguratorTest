package configurator.test.resources.json.url;

import javax.inject.Inject;
import javax.json.JsonArray;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonArrayUrlOkDefValueOk

// Ok URL with default value ok
@Path("/config")
public class JA_UrlOk_DefValueOk {
	
	@Inject
	@ConfigJson(url = "http://localhost:8080/ConfiguratorTest/res/json/array", defaultValue="[\"strElVal1\", \"strElVal2\"]")
	private TypedProperty<JsonArray> test;
	
	
	@Path("/jsonArrayUrlOkDefValueOk")
	@GET
	public Response testGet() {
		return Response.ok("Ok URL with default value ok: " + test).build();
	}
	
	@Path("/jsonArrayUrlOkDefValueOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonArray> testGetTest() {
		return test;
	}
}