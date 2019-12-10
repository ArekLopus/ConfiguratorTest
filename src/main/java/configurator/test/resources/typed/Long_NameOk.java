package configurator.test.resources.typed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigTyped;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedParameterLongNameOk

// Long typed property, name ok
@Path("/config")
public class Long_NameOk {
	
	@Inject
	@ConfigTyped(value = "testFilePropLong")
	private TypedProperty<Long> test;
	
	
	@Path("/typedParameterLongNameOk")
	@GET
	public Response testGet() {
		return Response.ok("Long typed property, name ok: " + test).build();
	}
	
	@Path("/typedParameterLongNameOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<Long> testGetTest() {
		return test;
	}
}