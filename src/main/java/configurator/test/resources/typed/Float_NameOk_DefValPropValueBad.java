package configurator.test.resources.typed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigTyped;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedParameterFloatNameOkDefValPropertyValueBad

// Float typed property, name ok default value property value bad
@Path("/config")
public class Float_NameOk_DefValPropValueBad {
	
	@Inject
	@ConfigTyped(value = "testFilePropFloat", defaultValueProperty = "testFilePropFloatDefValBad")
	private TypedProperty<Float> test;
	
	
	@Path("/typedParameterFloatNameOkDefValPropertyValueBad")
	@GET
	public Response testGet() {
		return Response.ok("Float typed property, name ok default value property value bad: " + test).build();
	}
	
	@Path("/typedParameterFloatNameOkDefValPropertyValueBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<Float> testGetTest() {
		return test;
	}
}