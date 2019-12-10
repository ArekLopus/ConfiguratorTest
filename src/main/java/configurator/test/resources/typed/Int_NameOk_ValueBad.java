package configurator.test.resources.typed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigTyped;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedParameterIntegerNameOkValueBad

// Integer typed property, name ok value bad
@Path("/config")
public class Int_NameOk_ValueBad {
	
	@Inject
	@ConfigTyped(value = "testFilePropIntBad")
	private TypedProperty<Integer> test;
	
	
	@Path("/typedParameterIntegerNameOkValueBad")
	@GET
	public Response testGet() {
		return Response.ok("Integer typed property, name ok value bad: " + test).build();
	}
	
	@Path("/typedParameterIntegerNameOkValueBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<Integer> testGetTest() {
		return test;
	}
}