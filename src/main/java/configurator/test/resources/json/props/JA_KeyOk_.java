package configurator.test.resources.json.props;

import javax.inject.Inject;
import javax.json.JsonArray;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonArrayKeyOk

// Ok property key
@Path("/config")
public class JA_KeyOk_ {
	
	@Inject
	@ConfigJson(property = "jsonArrayProp")
	private TypedProperty<JsonArray> test;
	
	@Path("/jsonArrayKeyOk")
	@GET
	public Response testGet() {
		return Response.ok("Ok property key: " + test).build();
	}
	
	@Path("/jsonArrayKeyOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonArray> testGetTest() {
		return test;
	}
}