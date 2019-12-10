package configurator.test.resources.typed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigTyped;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedParameterDoubleNameOkDefValOk

// Double typed property, name ok default value ok
@Path("/config")
public class Double_NameOk_DefValNameOk {
	
	@Inject
	@ConfigTyped(value = "testFilePropDouble", defaultValue = "2.22")
	private TypedProperty<Double> test;
	
	
	@Path("/typedParameterDoubleNameOkDefValOk")
	@GET
	public Response testGet() {
		return Response.ok("Double typed property, name ok default value ok: " + test).build();
	}
	
	@Path("/typedParameterDoubleNameOkDefValOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<Double> testGetTest() {
		return test;
	}
}