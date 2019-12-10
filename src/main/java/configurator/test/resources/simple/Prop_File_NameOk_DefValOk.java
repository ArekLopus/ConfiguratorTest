package configurator.test.resources.simple;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.annotations.Config;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/propsFileNameOkDefValOk

// Properties file name ok default value ok
@Path("/config")
@Produces(MediaType.TEXT_PLAIN)
public class Prop_File_NameOk_DefValOk {
	
	@Inject
	@Config(value = "testFileProp", defaultValue = "No System variable 'testFileProp'")
	String test;
	
	
	@Path("/propsFileNameOkDefValOk")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response testGetEnv() {
		return Response.ok("Properties file name ok default value ok: " + test).build();
	}
	
	@Path("/propsFileNameOkDefValOk/test")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testGetTest() {
		return test;
	}
}