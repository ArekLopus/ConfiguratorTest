package configurator.test.resources.simple;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.annotations.Config;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/propsFileNameBadDefValOk

// Properties file name bad default value ok
@Path("/config")
@Produces(MediaType.TEXT_PLAIN)
public class Prop_File_NameBad_DefValOk {
	
	@Inject
	@Config(value = "FilePropBadName", defaultValue = "No File variable 'FilePropBadName'")
	String test;
	
	
	@Path("/propsFileNameBadDefValOk")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response testGetEnv() {
		return Response.ok("Properties file name bad default value ok: " + test).build();
	}
	
	@Path("/propsFileNameBadDefValOk/test")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testGetTest() {
		return test;
	}
}