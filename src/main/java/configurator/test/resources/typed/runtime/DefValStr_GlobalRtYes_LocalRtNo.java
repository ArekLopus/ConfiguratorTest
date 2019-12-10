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
// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedDefValGlobalRuntimeYesLocalRuntimeNo (never reloads)

// Change runtime first to set proper runtime check
// Ok property name, global runtime check YES, local runtime check NO
@Path("/config")
public class DefValStr_GlobalRtYes_LocalRtNo {
	
	@Inject
	@ConfigTyped(value = "BadName", defaultValueProperty = "testFilePropDefVal", runtimeCheck = RuntimeCheckType.NO)
	private TypedProperty<String> test;
	
	
	@Path("/typedDefValGlobalRuntimeYesLocalRuntimeNo")
	@GET
	public Response testGet() {
		return Response.ok("Ok property name, global runtime check YES, local runtime check NO (never reloads): " + test).build();
	}
	
	@Path("/typedDefValGlobalRuntimeYesLocalRuntimeNo/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<String> testGetTest() {
		return test;
	}
}