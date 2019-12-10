package configurator.test.resources.typed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigTyped;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedParameterDoubleNameOkDefValBad

// Double typed property, name ok default value bad
@Path("/config")
public class Double_NameOk_DefValNameBad {
	
	@Inject
	@ConfigTyped(value = "testFilePropDouble", defaultValue = "valueBad")
	private TypedProperty<Double> test;
	
	
	@Path("/typedParameterDoubleNameOkDefValBad")
	@GET
	public Response testGet() {
		return Response.ok("Double typed property, name ok default value bad: " + test).build();
	}
	
	@Path("/typedParameterDoubleNameOkDefValBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<Double> testGetTest() {
		return test;
	}
}