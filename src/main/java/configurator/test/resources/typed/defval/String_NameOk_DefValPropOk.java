package configurator.test.resources.typed.defval;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigTyped;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedParameterStringDefValPropertyOk

// Parameterized type String, default value property ok
@Path("/config")
public class String_NameOk_DefValPropOk {
	
	@Inject
	@ConfigTyped(value = "BadName", defaultValueProperty = "testFilePropDefVal")
	private TypedProperty<String> test;
	
	
	@Path("/typedParameterStringDefValPropertyOk")
	@GET
	public Response testGet() {
		return Response.ok("Parameterized type String, default value property ok: " + test).build();
	}
	
	@Path("/typedParameterStringDefValPropertyOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<String> testGetTest() {
		return test;
	}
}