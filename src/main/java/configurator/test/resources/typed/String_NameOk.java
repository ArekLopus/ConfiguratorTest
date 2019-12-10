package configurator.test.resources.typed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigTyped;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedParameterStringNameOk

// Parameterized type String for typed property, name ok
@Path("/config")
public class String_NameOk {
	
	@Inject
	@ConfigTyped(value = "testFileProp")
	private TypedProperty<String> test;
	
	
	@Path("/typedParameterStringNameOk")
	@GET
	public Response testGet() {
		return Response.ok("Parameterized type String for typed property, name ok: " + test).build();
	}
	
	@Path("/typedParameterStringNameOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<String> testGetTest() {
		return test;
	}
}