package configurator.test.resources.simple;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.annotations.Config;
import configurator.enums.RuntimeCheckType;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/changeRuntime/false
// curl -i http://localhost:8080/ConfiguratorTest/res/config/PropertiesGlobalRuntimeNoLocalRuntimeYes

// Change runtime first to set proper runtime check
// Ok property name, global runtime check NO, local runtime check YES (always reloads)
@Path("/config")
public class Prop_GlobalRtNo_LocalRtYes {
	
	@Inject
	@Config(value = "testFileProp", runtimeCheck = RuntimeCheckType.YES)
	private String test;
	
	
	@Path("/PropertiesGlobalRuntimeNoLocalRuntimeYes")
	@GET
	public Response testGet() {
		return Response.ok("Ok property name, global runtime check NO, local runtime check YES (always reloads): " + test).build();
	}
	
	@Path("/PropertiesGlobalRuntimeNoLocalRuntimeYes/test")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testGetTest() {
		return test;
	}
}