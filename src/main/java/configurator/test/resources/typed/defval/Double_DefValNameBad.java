package configurator.test.resources.typed.defval;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigTyped;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedParameterDoubleDefValBad

// Double typed, default value bad
@Path("/config")
public class Double_DefValNameBad {
	
	@Inject
	@ConfigTyped(value = "BadName", defaultValue = "valueBad")
	private TypedProperty<Double> test;
	
	
	@Path("/typedParameterDoubleDefValBad")
	@GET
	public Response testGet() {
		return Response.ok("Double typed, default value bad: " + test).build();
	}
	
	@Path("/typedParameterDoubleDefValBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<Double> testGetTest() {
		return test;
	}
}