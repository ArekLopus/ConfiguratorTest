package configurator.test.resources.typed.runtime;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigTyped;
import configurator.enums.RuntimeCheckType;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/changeRuntime/false
// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedDefValGlobalRuntimeNoLocalRuntimeUseGl

// Change runtime first to set proper runtime check
// Ok property name, global runtime check NO, local runtime check USE GLOBAL (never reloads)
@Path("/config")
public class DefValStr_GlobalRtNo_LocalRtUseGl {
	
	@Inject
	@ConfigTyped(value = "BadName", defaultValueProperty = "testFilePropDefVal", runtimeCheck = RuntimeCheckType.USE_GLOBAL)
	private TypedProperty<String> test;
	
	
	@Path("/typedDefValGlobalRuntimeNoLocalRuntimeUseGl")
	@GET
	public Response testGet() {
		return Response.ok("Ok property name, global runtime check NO, local runtime check USE GLOBAL (never reloads): " + test).build();
	}
	
	@Path("/typedDefValGlobalRuntimeNoLocalRuntimeUseGl/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<String> testGetTest() {
		return test;
	}
}