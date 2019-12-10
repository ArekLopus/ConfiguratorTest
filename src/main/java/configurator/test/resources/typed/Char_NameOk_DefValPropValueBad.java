package configurator.test.resources.typed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigTyped;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedParameterCharacterNameOkDefValPropertyValueBad

// Character typed property, name ok default value property value bad
@Path("/config")
public class Char_NameOk_DefValPropValueBad {
	
	@Inject
	@ConfigTyped(value = "testFilePropChar", defaultValueProperty = "testFilePropCharDefValBad")
	private TypedProperty<Character> test;
	
	
	@Path("/typedParameterCharacterNameOkDefValPropertyValueBad")
	@GET
	public Response testGet() {
		return Response.ok("Character typed property, name ok default value property value bad: " + test).build();
	}
	
	@Path("/typedParameterCharacterNameOkDefValPropertyValueBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<Character> testGetTest() {
		return test;
	}
}