package configurator.test.resources.typed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigTyped;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedParameterDoubleNameOkDefValPropertyValueBad

// Double typed property, name ok default value property value bad
@Path("/config")
public class Double_NameOk_DefValPropValueBad {
	
	@Inject
	@ConfigTyped(value = "testFilePropDouble", defaultValueProperty = "testFilePropDoubleDefValBad")
	private TypedProperty<Double> test;
	
	
	@Path("/typedParameterDoubleNameOkDefValPropertyValueBad")
	@GET
	public Response testGet() {
		return Response.ok("Double typed property, name ok default value property value bad: " + test).build();
	}
	
	@Path("/typedParameterDoubleNameOkDefValPropertyValueBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<Double> testGetTest() {
		return test;
	}
}