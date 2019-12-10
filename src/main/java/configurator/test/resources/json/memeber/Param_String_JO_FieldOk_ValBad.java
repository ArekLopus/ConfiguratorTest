package configurator.test.resources.json.memeber;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectMemberFieldParemeterStringNameOkValueBad

// Parameterized type String, field name ok value bad 
@Path("/config")
public class Param_String_JO_FieldOk_ValBad {
	
	String jos = "{\"strFieldKey1\" : \"strFieldVal1\", \"strFieldKey2\": \"strFieldVa2\"";
	
	@Inject
	@ConfigJson(classMember = "jos")
	private TypedProperty<String> test;
	
	
	@Path("/jsonObjectMemberFieldParemeterStringNameOkValueBad")
	@GET
	public Response testGet() {
		return Response.ok("Parameterized type String, field name ok value bad: " + test).build();
	}
	
	@Path("/jsonObjectMemberFieldParemeterStringNameOkValueBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<String> testGetTest() {
		return test;
	}
}