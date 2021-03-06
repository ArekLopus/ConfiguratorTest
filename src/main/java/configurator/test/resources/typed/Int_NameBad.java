package configurator.test.resources.typed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigTyped;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedParameterIntegerNameBad

// Integer typed property, name bad
@Path("/config")
public class Int_NameBad {
	
	@Inject
	@ConfigTyped("IntBadPropertyName")
	private TypedProperty<Integer> test;
	
	
	@Path("/typedParameterIntegerNameBad")
	@GET
	public Response testGet() {
		return Response.ok("Integer typed property, name bad: " + test).build();
	}
	
	@Path("/typedParameterIntegerNameBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<Integer> testGetTest() {
		return test;
	}
}