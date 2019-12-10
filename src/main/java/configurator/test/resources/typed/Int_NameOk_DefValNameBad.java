package configurator.test.resources.typed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigTyped;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedParameterIntegerNameOkDefValBad

// Integer typed property, name ok default value bad
@Path("/config")
public class Int_NameOk_DefValNameBad {
	
	@Inject
	@ConfigTyped(value = "testFilePropInt", defaultValue = "valueBad")
	private TypedProperty<Integer> test;
	
	
	@Path("/typedParameterIntegerNameOkDefValBad")
	@GET
	public Response testGet() {
		return Response.ok("Integer typed property, name ok default value bad: " + test).build();
	}
	
	@Path("/typedParameterIntegerNameOkDefValBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<Integer> testGetTest() {
		return test;
	}
}