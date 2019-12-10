package configurator.test.resources.simple;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.annotations.Config;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/propsSystemNameOk

// Properties System name ok
@Path("/config")
@Produces(MediaType.TEXT_PLAIN)
public class Prop_System_NameOk {
	
	@Inject
	@Config(value = "testSystemProp")
	String test;
	
	
	@Path("/propsSystemNameOk")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response testGetEnv() {
		return Response.ok("Properties System name ok: " + test).build();
	}
	
	@Path("/propsSystemNameOk/test")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testGetTest() {
		return test;
	}
}