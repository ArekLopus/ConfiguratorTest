package configurator.test.resources.json.defval;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/StringFieldNameOkValueBad

// Parameterized type String, default value class member field name ok value bad
@Path("/config")
public class Param_String_FldOk_ValBad {
	
	String jos = "{\"error\" : \"String - There was an error loading value.\"";
	
	@Inject
//	@ConfigJson(classMember = "jo", defaultValueIsClassMember = "jodv")
	@ConfigJson(defaultValueIsClassMember = "jos")
	private TypedProperty<String> test;
	
	
	@Path("/StringFieldNameOkValueBad")
	@GET
	public Response testGet() {
		return Response.ok("Parameterized type String, default value class member field name ok value bad: " + test).build();
	}
	
	@Path("/StringFieldNameOkValueBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<String> testGetTest() {
		return test;
	}
}