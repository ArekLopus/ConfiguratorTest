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
// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedIntegerGlobalRuntimeNoLocalRuntimeYes

// Change runtime first to set proper runtime check
// Ok property name, global runtime check NO, local runtime check YES (always reloads)
@Path("/config")
public class ValueInt_GlobalRtNo_LocalRtYes {
	
	@Inject
	@ConfigTyped(value = "testFilePropInt", runtimeCheck = RuntimeCheckType.YES)
	private TypedProperty<Integer> test;
	
	
	@Path("/typedIntegerGlobalRuntimeNoLocalRuntimeYes")
	@GET
	public Response testGet() {
		return Response.ok("Ok property name, global runtime check NO, local runtime check YES (always reloads): " + test).build();
	}
	
	@Path("/typedIntegerGlobalRuntimeNoLocalRuntimeYes/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<Integer> testGetTest() {
		return test;
	}
}