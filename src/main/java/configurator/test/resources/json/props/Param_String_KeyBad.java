package configurator.test.resources.json.props;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectPropParameterStringKeyBad

// Parameterized type String, property name bad
@Path("/config")
@Produces(MediaType.TEXT_PLAIN)
public class Param_String_KeyBad {
	
	@Inject
	@ConfigJson(property = "jsonObjectBadName")
	private TypedProperty<String> test;
	
	
	@Path("/jsonObjectPropParameterStringKeyBad")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response testGet() {
		return Response.ok("Parameterized type String, property name bad: " + test).build();
	}
	
	@Path("/jsonObjectPropParameterStringKeyBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<String> testGetTest() {
		return test;
	}
}