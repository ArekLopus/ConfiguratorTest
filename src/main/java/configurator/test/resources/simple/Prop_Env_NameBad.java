package configurator.test.resources.simple;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.annotations.Config;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/propsEnvNameBad

// Properties ENV name bad
@Path("/config")
@Produces(MediaType.TEXT_PLAIN)
public class Prop_Env_NameBad {
	
	@Inject
	@Config(value = "EnvVarBadName")
	String test;
	
	
	@Path("/propsEnvNameBad")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response testGetEnv() {
		return Response.ok("Properties ENV name bad: " + test).build();
	}
	
	@Path("/propsEnvNameBad/test")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testGetTest() {
		return test;
	}
}