package configurator.test.resources.typed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigTyped;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedParameterShortNameOkValueBad

// Short typed property, name ok value bad
@Path("/config")
public class Short_NameOk_ValueBad {
	
	@Inject
	@ConfigTyped(value = "testFilePropShortBad")
	private TypedProperty<Short> test;
	
	
	@Path("/typedParameterShortNameOkValueBad")
	@GET
	public Response testGet() {
		return Response.ok("Short typed property, name ok value bad: " + test).build();
	}
	
	@Path("/typedParameterShortNameOkValueBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<Short> testGetTest() {
		return test;
	}
}