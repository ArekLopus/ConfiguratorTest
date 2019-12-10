package configurator.test.resources.json.defval;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/StringPropertyNameOk

// Parameterized type String, default value property name ok
@Path("/config")
public class Param_String_PropOk {
	
	@Inject
	//@ConfigJson(property = "jsonObject", defaultValueProperty = "jsonObjectDefValProp")
	@ConfigJson(defaultValueProperty = "jsonObjectDefValProp")
	private TypedProperty<String> test;
	
	
	@Path("/StringPropertyNameOk")
	@GET
	public Response testGet() {
		return Response.ok("Parameterized type String, default value property name ok: " + test).build();
	}
	
	@Path("/StringPropertyNameOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<String> testGetTest() {
		return test;
	}
}