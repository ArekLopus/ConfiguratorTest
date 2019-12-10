package configurator.test.resources.simple;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.annotations.Config;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/propsEnvNameOk

// Properties ENV name ok
@Path("/config")
@Produces(MediaType.TEXT_PLAIN)
public class Prop_Env_NameOk {
	
	@Inject
	@Config(value = "testEnvVar")
	String test;
	
	
	@Path("/propsEnvNameOk")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response testGetEnv() {
		return Response.ok("Properties ENV name ok: " + test).build();
	}
	
	@Path("/propsEnvNameOk/test")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testGetTest() {
		return test;
	}
}