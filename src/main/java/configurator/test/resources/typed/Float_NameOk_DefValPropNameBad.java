package configurator.test.resources.typed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigTyped;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedParameterFloatNameOkDefValPropertyBad

// Float typed property, name ok default value property bad
@Path("/config")
public class Float_NameOk_DefValPropNameBad {
	
	@Inject
	@ConfigTyped(value = "testFilePropFloat", defaultValueProperty = "testFilePropFloatDefValNameBad")
	private TypedProperty<Float> test;
	
	
	@Path("/typedParameterFloatNameOkDefValPropertyBad")
	@GET
	public Response testGet() {
		return Response.ok("Long typed property, name ok default value property bad: " + test).build();
	}
	
	@Path("/typedParameterFloatNameOkDefValPropertyBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<Float> testGetTest() {
		return test;
	}
}