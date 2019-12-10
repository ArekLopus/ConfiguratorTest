package configurator.test.resources.json.defval;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/StringUrlNameOkValueBad

// Parameterized type String, default value url name ok value bad
@Path("/config")
public class Param_String_UrlOk_ValBad {
	
	@Inject
//	@ConfigJson(url = "http://localhost:8080/ConfiguratorTest/res/json/object",	defaultValueUrl = "http://localhost:8080/ConfiguratorTest/res/json/objectDefVal")
	@ConfigJson(defaultValueUrl = "http://localhost:8080/ConfiguratorTest/res/json/objectDefValBad")
	private TypedProperty<String> test;
	
	
	@Path("/StringUrlNameOkValueBad")
	@GET
	public Response testGet() {
		return Response.ok("Parameterized type String, default value property name ok value bad: " + test).build();
	}
	
	@Path("/StringUrlNameOkValueBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<String> testGetTest() {
		return test;
	}
}