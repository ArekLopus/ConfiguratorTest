package configurator.test.resources.json.props;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectPropParameterStringValueBad

// Parameterized type String, property name ok value bad
@Path("/config")
@Produces(MediaType.TEXT_PLAIN)
public class Param_String_KeyOk_ValueBad {
	
	@Inject
	@ConfigJson(property = "jsonObjectPropBad")
	private TypedProperty<String> test;
	
	
	@Path("/jsonObjectPropParameterStringValueBad")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response testGet() {
		return Response.ok("Parameterized type String, property name ok value bad: " + test).build();
	}
	
	@Path("/jsonObjectPropParameterStringValueBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<String> testGetTest() {
		return test;
	}
}