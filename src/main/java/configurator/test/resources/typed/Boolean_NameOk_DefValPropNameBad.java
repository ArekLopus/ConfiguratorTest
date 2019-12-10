package configurator.test.resources.typed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigTyped;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedParameterBooleanNameOkDefValPropertyBad

// Boolean typed property, name ok default value property bad
@Path("/config")
public class Boolean_NameOk_DefValPropNameBad {
	
	@Inject
	@ConfigTyped(value = "testFilePropBoolean", defaultValueProperty = "testFilePropBooleanDefValNameBad")
	private TypedProperty<Boolean> test;
	
	
	@Path("/typedParameterBooleanNameOkDefValPropertyBad")
	@GET
	public Response testGet() {
		return Response.ok("Boolean typed property, name ok default value property bad: " + test).build();
	}
	
	@Path("/typedParameterBooleanNameOkDefValPropertyBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<Boolean> testGetTest() {
		return test;
	}
}