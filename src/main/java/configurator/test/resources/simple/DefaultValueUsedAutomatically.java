package configurator.test.resources.simple;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.annotations.Config;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/defaultValueUsedAutomatically

// If a value is not available a default value is used automatically
@Path("/config")
@Produces(MediaType.TEXT_PLAIN)
public class DefaultValueUsedAutomatically {
	
	@Inject
	@Config(value = "testFilePropBadName", defaultValue = "There was an error getting 'testFilePropBadName' property.")
	String test;
	
	
	@Path("/defaultValueUsedAutomatically")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response testGetEnv() {
		return Response.ok("If a value is not available a default value is used automatically: " + test).build();
	}
	
	@Path("/defaultValueUsedAutomatically/test")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testGetTest() {
		return test;
	}
}