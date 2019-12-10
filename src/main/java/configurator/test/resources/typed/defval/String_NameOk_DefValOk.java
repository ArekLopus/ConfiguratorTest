package configurator.test.resources.typed.defval;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigTyped;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedParameterStringDefValOk

// Parameterized type String, default value ok
@Path("/config")
public class String_NameOk_DefValOk {
	
	@Inject
	@ConfigTyped(value = "BadName", defaultValue = "Default Value is OK")
	private TypedProperty<String> test;
	
	
	@Path("/typedParameterStringDefValOk")
	@GET
	public Response testGet() {
		return Response.ok("Parameterized type String, default value ok: " + test).build();
	}
	
	@Path("/typedParameterStringDefValOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<String> testGetTest() {
		return test;
	}
}