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

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonArrayUrlOk

// Ok URL JsonArray
@Path("/config")
public class JA_UrlOk {
	
	@Inject
	@ConfigJson(url = "http://localhost:8080/ConfiguratorTest/res/json/array")
	private TypedProperty<JsonArray> test;
	
	
	@Path("/jsonArrayUrlOk")
	@GET
	public Response testGet() {
		return Response.ok("Ok URL JsonArray: " + test).build();
	}
	
	@Path("/jsonArrayUrlOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonArray> testGetTest() {
		return test;
	}
}