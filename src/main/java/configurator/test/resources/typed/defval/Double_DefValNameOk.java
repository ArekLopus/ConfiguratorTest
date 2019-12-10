package configurator.test.resources.typed.defval;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigTyped;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedParameterDoubleDefValOk

// Double typed, default value ok
@Path("/config")
public class Double_DefValNameOk {
	
	@Inject
	@ConfigTyped(value = "BadName", defaultValue = "2.22")
	private TypedProperty<Double> test;
	
	
	@Path("/typedParameterDoubleDefValOk")
	@GET
	public Response testGet() {
		return Response.ok("Double typed, default value ok: " + test).build();
	}
	
	@Path("/typedParameterDoubleDefValOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<Double> testGetTest() {
		return test;
	}
}