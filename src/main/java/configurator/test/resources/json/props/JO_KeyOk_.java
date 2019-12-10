package configurator.test.resources.json.props;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectPropKeyOk

// Ok property key
@Path("/config")
public class JO_KeyOk_ {
	
	@Inject
	@ConfigJson(property = "jsonObjectProp")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/jsonObjectPropKeyOk")
	@GET
	public Response testGet() {
		return Response.ok("Ok property key: " + test).build();
	}
	
	@Path("/jsonObjectPropKeyOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
}