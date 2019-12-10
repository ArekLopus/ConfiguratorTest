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

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectUrlOk

// Ok URL JsonObject
@Path("/config")
public class JO_UrlOk_ {
	
	@Inject
	@ConfigJson(url = "http://localhost:8080/ConfiguratorTest/res/json/object")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/jsonObjectUrlOk")
	@GET
	public Response testGet() {
		return Response.ok("Ok URL JsonObject: " + test).build();
	}
	
	@Path("/jsonObjectUrlOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
	
}