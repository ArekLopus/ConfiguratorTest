package configurator.test.resources.typed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigTyped;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedParameterStringNameBad

// Parameterized type String for typed property, name bad
@Path("/config")
public class String_NameBad {
	
	@Inject
	@ConfigTyped("BadPropertyName")
	private TypedProperty<String> test;
	
	
	@Path("/typedParameterStringNameBad")
	@GET
	public Response testGet() {
		return Response.ok("Parameterized type String for typed property, name bad: " + test).build();
	}
	
	@Path("/typedParameterStringNameBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<String> testGetTest() {
		return test;
	}
}