package configurator.test.resources.typed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigTyped;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedParameterCharacterNameOkDefValPropertyBad

// Character typed property, name ok default value property bad
@Path("/config")
public class Char_NameOk_DefValPropNameBad {
	
	@Inject
	@ConfigTyped(value = "testFilePropChar", defaultValueProperty = "testFilePropCharDefValNameBad")
	private TypedProperty<Character> test;
	
	
	@Path("/typedParameterCharacterNameOkDefValPropertyBad")
	@GET
	public Response testGet() {
		return Response.ok("Character typed property, name ok default value property bad: " + test).build();
	}
	
	@Path("/typedParameterCharacterNameOkDefValPropertyBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<Character> testGetTest() {
		return test;
	}
}