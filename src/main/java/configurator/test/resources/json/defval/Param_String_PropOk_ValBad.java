package configurator.test.resources.json.defval;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/StringPropertyNameOkValueBad

// Parameterized type String, default value property name ok value bad
@Path("/config")
public class Param_String_PropOk_ValBad {
	
	@Inject
	//@ConfigJson(property = "jsonObject", defaultValueProperty = "jsonObjectDefValProp")
	@ConfigJson(defaultValueProperty = "jsonObjectDefValPropBad")
	private TypedProperty<String> test;
	
	
	@Path("/StringPropertyNameOkValueBad")
	@GET
	public Response testGet() {
		return Response.ok("Parameterized type String, default value property name ok value bad: " + test).build();
	}
	
	@Path("/StringPropertyNameOkValueBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<String> testGetTest() {
		return test;
	}
}