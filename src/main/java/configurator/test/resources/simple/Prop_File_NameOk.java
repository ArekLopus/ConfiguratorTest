package configurator.test.resources.simple;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.annotations.Config;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/propsFileNameOk

// Properties file name ok
@Path("/config")
@Produces(MediaType.TEXT_PLAIN)
public class Prop_File_NameOk {
	
	@Inject
	@Config(value = "testFileProp")
	String test;
	
	
	@Path("/propsFileNameOk")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response testGetEnv() {
		return Response.ok("Properties file name ok: " + test).build();
	}
	
	@Path("/propsFileNameOk/test")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testGetTest() {
		return test;
	}
}