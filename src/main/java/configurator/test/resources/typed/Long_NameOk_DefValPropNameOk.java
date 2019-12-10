package configurator.test.resources.typed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigTyped;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedParameterLongNameOkDefValPropertyOk

// Long typed property, name ok default value property ok
@Path("/config")
public class Long_NameOk_DefValPropNameOk {
	
	@Inject
	@ConfigTyped(value = "testFilePropLong", defaultValueProperty = "testFilePropLongDefVal")
	private TypedProperty<Long> test;
	
	
	@Path("/typedParameterLongNameOkDefValPropertyOk")
	@GET
	public Response testGet() {
		return Response.ok("Long typed property, name ok default value property ok: " + test).build();
	}
	
	@Path("/typedParameterLongNameOkDefValPropertyOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<Long> testGetTest() {
		return test;
	}
}