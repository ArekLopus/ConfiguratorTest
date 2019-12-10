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
// curl -i http://localhost:8080/ConfiguratorTest/res/config/PropertiesGlobalRuntimeNoLocalRuntimeNo

// Change runtime first to set proper runtime check
// Ok property name, global runtime check NO, local runtime check NO (never reloads)
@Path("/config")
public class Prop_GlobalRtNo_LocalRtNo {
	
	@Inject
	@Config(value = "testFileProp", runtimeCheck = RuntimeCheckType.NO)
	private String test;
	
	
	@Path("/PropertiesGlobalRuntimeNoLocalRuntimeNo")
	@GET
	public Response testGet() {
		return Response.ok("Ok property name, global runtime check NO, local runtime check NO (never reloads): " + test).build();
	}
	
	@Path("/PropertiesGlobalRuntimeNoLocalRuntimeNo/test")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testGetTest() {
		return test;
	}
	
}