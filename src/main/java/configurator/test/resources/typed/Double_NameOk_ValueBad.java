package configurator.test.resources.typed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigTyped;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedParameterDoubleNameOkValueBad

// Double typed property, name ok value bad
@Path("/config")
public class Double_NameOk_ValueBad {
	
	@Inject
	@ConfigTyped(value = "testFilePropDoubleBad")
	private TypedProperty<Double> test;
	
	
	@Path("/typedParameterDoubleNameOkValueBad")
	@GET
	public Response testGet() {
		return Response.ok("Double typed property, name ok value bad: " + test).build();
	}
	
	@Path("/typedParameterDoubleNameOkValueBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<Double> testGetTest() {
		return test;
	}
}