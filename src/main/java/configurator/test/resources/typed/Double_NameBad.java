package configurator.test.resources.typed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigTyped;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedParameterDoubleNameBad

// Double typed property, name bad
@Path("/config")
public class Double_NameBad {
	
	@Inject
	@ConfigTyped("DoubleBadPropertyName")
	private TypedProperty<Double> test;
	
	
	@Path("/typedParameterDoubleNameBad")
	@GET
	public Response testGet() {
		return Response.ok("Double typed property, name bad: " + test).build();
	}
	
	@Path("/typedParameterDoubleNameBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<Double> testGetTest() {
		return test;
	}
}