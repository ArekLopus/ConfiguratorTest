package configurator.test.resources.typed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigTyped;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedParameterFloatNameOkDefValPropertyOk

// Float typed property, name ok default value property ok
@Path("/config")
public class Float_NameOk_DefValPropNameOk {
	
	@Inject
	@ConfigTyped(value = "testFilePropFloat", defaultValueProperty = "testFilePropFloatDefVal")
	private TypedProperty<Float> test;
	
	
	@Path("/typedParameterFloatNameOkDefValPropertyOk")
	@GET
	public Response testGet() {
		return Response.ok("Float typed property, name ok default value property ok: " + test).build();
	}
	
	@Path("/typedParameterFloatNameOkDefValPropertyOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<Float> testGetTest() {
		return test;
	}
}