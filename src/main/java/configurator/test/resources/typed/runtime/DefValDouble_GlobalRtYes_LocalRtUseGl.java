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

// curl -i http://localhost:8080/ConfiguratorTest/res/config/changeRuntime/true
// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedDoubleDefValGlobalRuntimeYesLocalRuntimeUseGl

// Change runtime first to set proper runtime check
// Ok property name, global runtime check YES, local runtime check USE GLOBAL (always reloads)
@Path("/config")
public class DefValDouble_GlobalRtYes_LocalRtUseGl {
	
	@Inject
	@ConfigTyped(value = "BadName", defaultValueProperty = "testFilePropDoubleDefVal", runtimeCheck = RuntimeCheckType.USE_GLOBAL)
	private TypedProperty<Double> test;
	
	
	@Path("/typedDoubleDefValGlobalRuntimeYesLocalRuntimeUseGl")
	@GET
	public Response testGet() {
		return Response.ok("Ok property name, global runtime check YES, local runtime check USE GLOBAL (always reloads): " + test).build();
	}
	
	@Path("/typedDoubleDefValGlobalRuntimeYesLocalRuntimeUseGl/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<Double> testGetTest() {
		return test;
	}
}