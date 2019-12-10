package configurator.test.resources.simple;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.annotations.Config;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/propsSystemNameBadDefValOk

// Properties System name bad default value ok
@Path("/config")
@Produces(MediaType.TEXT_PLAIN)
public class Prop_System_NameBad_DefValOk {
	
	@Inject
	@Config(value = "SystemPropBadName", defaultValue = "No System variable 'SystemPropBadName'")
	String test;
	
	
	@Path("/propsSystemNameBadDefValOk")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response testGetEnv() {
		return Response.ok("Properties System name bad default value ok: " + test).build();
	}
	
	@Path("/propsSystemNameBadDefValOk/test")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testGetTest() {
		return test;
	}
}