package configurator.test.resources.typed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigTyped;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedParameterFloatNameOkDefValBad

// Float typed property, name ok default value bad
@Path("/config")
public class Float_NameOk_DefValNameBad {
	
	@Inject
	@ConfigTyped(value = "testFilePropFloat", defaultValue = "valueBad")
	private TypedProperty<Float> test;
	
	
	@Path("/typedParameterFloatNameOkDefValBad")
	@GET
	public Response testGet() {
		return Response.ok("Float typed property, name ok default value bad: " + test).build();
	}
	
	@Path("/typedParameterFloatNameOkDefValBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<Float> testGetTest() {
		return test;
	}
}