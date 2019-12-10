package configurator.test.resources.typed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigTyped;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedParameterShortNameOkDefValOk

// Short typed property, name ok default value ok
@Path("/config")
public class Short_NameOk_DefValNameOk {
	
	@Inject
	@ConfigTyped(value = "testFilePropShort", defaultValue = "321")
	private TypedProperty<Short> test;
	
	
	@Path("/typedParameterShortNameOkDefValOk")
	@GET
	public Response testGet() {
		return Response.ok("Short typed property, name ok default value ok: " + test).build();
	}
	
	@Path("/typedParameterShortNameOkDefValOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<Short> testGetTest() {
		return test;
	}
}