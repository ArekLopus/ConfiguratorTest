package configurator.test.resources.json.defval;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/StringDefValString

// Parameterized type String, default value (String) ok
@Path("/config")
public class Param_String_DefValOk {
	
	@Inject
//	@ConfigJson(property = "jsonObject", defaultValue = "{\"error\" : \"String - There was an error loading value.\"}")
	@ConfigJson(defaultValue = "{\"error\" : \"String - There was an error loading value.\"}")
	private TypedProperty<String> test;
	
	
	@Path("/StringDefValString")
	@GET
	public Response testGet() {
		return Response.ok("Parameterized type String, default value (String) ok: " + test).build();
	}
	
	@Path("/StringDefValString/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<String> testGetTest() {
		return test;
	}
}