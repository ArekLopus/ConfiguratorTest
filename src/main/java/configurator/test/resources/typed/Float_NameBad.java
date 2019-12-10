package configurator.test.resources.typed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigTyped;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedParameterFloatNameBad

// Float typed property, name bad
@Path("/config")
public class Float_NameBad {
	
	@Inject
	@ConfigTyped("FloatBadPropertyName")
	private TypedProperty<Float> test;
	
	
	@Path("/typedParameterFloatNameBad")
	@GET
	public Response testGet() {
		return Response.ok("Float typed property, name bad: " + test).build();
	}
	
	@Path("/typedParameterFloatNameBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<Float> testGetTest() {
		return test;
	}
}