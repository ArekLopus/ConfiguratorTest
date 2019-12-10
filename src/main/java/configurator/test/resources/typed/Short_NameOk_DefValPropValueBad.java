package configurator.test.resources.typed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigTyped;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedParameterShortNameOkDefValPropertyValueBad

// Short typed property, name ok default value property value bad
@Path("/config")
public class Short_NameOk_DefValPropValueBad {
	
	@Inject
	@ConfigTyped(value = "testFilePropShort", defaultValueProperty = "testFilePropShortDefValBad")
	private TypedProperty<Short> test;
	
	
	@Path("/typedParameterShortNameOkDefValPropertyValueBad")
	@GET
	public Response testGet() {
		return Response.ok("Short typed property, name ok default value property value bad: " + test).build();
	}
	
	@Path("/typedParameterShortNameOkDefValPropertyValueBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<Short> testGetTest() {
		return test;
	}
}