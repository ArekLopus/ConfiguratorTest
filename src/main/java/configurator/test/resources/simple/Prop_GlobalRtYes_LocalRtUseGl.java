package configurator.test.resources.simple;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.annotations.Config;
import configurator.enums.RuntimeCheckType;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/changeRuntime/true
// curl -i http://localhost:8080/ConfiguratorTest/res/config/PropertiesGlobalRuntimeYesLocalRuntimeUseGl

// Change runtime first to set proper runtime check
// Ok property name, global runtime check YES, local runtime check USE GLOBAL (always reloads)
@Path("/config")
public class Prop_GlobalRtYes_LocalRtUseGl {
	
	@Inject
	@Config(value = "testFileProp", runtimeCheck = RuntimeCheckType.USE_GLOBAL)
	private String test;
	
	
	@Path("/PropertiesGlobalRuntimeYesLocalRuntimeUseGl")
	@GET
	public Response testGet() {
		return Response.ok("Ok property name, global runtime check YES, local runtime check USE GLOBAL (always reloads): " + test).build();
	}
	
	@Path("/PropertiesGlobalRuntimeYesLocalRuntimeUseGl/test")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testGetTest() {
		return test;
	}
}