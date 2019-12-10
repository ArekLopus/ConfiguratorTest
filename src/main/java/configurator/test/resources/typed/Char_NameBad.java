package configurator.test.resources.typed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigTyped;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedParameterCharacterNameBad

// Character typed property, name bad
@Path("/config")
public class Char_NameBad {
	
	@Inject
	@ConfigTyped("CharBadPropertyName")
	private TypedProperty<Character> test;
	
	
	@Path("/typedParameterCharacterNameBad")
	@GET
	public Response testGet() {
		return Response.ok("Character typed property, name bad: " + test).build();
	}
	
	@Path("/typedParameterCharacterNameBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<Character> testGetTest() {
		return test;
	}
}