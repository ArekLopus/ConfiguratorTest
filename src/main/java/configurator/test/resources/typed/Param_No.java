package configurator.test.resources.typed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigTyped;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedParemeterNo

// No parameter for JsonObject
@Path("/config")
@SuppressWarnings("rawtypes")
public class Param_No {
	
	@Inject
	@ConfigTyped(value = "testFileProp")
	private TypedProperty test;
	
	
	@Path("/typedParemeterNo")
	@GET
	public Response testGet() {
		return Response.ok("No parameter for typed property: " + test).build();
	}
	
	@Path("/typedParemeterNo/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty testGetTest() {
		return test;
	}
}