package configurator.test.resources.simple;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.annotations.Config;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/propsFileNameBad

// Properties file name bad
@Path("/config")
@Produces(MediaType.TEXT_PLAIN)
public class Prop_File_NameBad {
	
	@Inject
	@Config(value = "FilePropBadName")
	String test;
	
	
	@Path("/propsFileNameBad")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response testGetEnv() {
		return Response.ok("Properties file name bad: " + test).build();
	}
	
	@Path("/propsFileNameBad/test")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testGetTest() {
		return test;
	}
}