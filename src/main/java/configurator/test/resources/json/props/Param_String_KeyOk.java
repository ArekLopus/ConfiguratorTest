package configurator.test.resources.json.props;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectPropParameterStringKeyOk

// Parameterized type String, property name ok
@Path("/config")
@Produces(MediaType.TEXT_PLAIN)
public class Param_String_KeyOk {
	
	@Inject
	@ConfigJson(property = "jsonObjectProp")
	private TypedProperty<String> test;
	
	
	@Path("/jsonObjectPropParameterStringKeyOk")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response testGet() {
		return Response.ok("Parameterized type String, property name ok: " + test).build();
	}
	
	@Path("/jsonObjectPropParameterStringKeyOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<String> testGetTest() {
		return test;
	}
}