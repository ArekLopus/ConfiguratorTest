package configurator.test.resources.json.memeber;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectMemberMethodParemeterStringNameOkValBad

// Parameterized type String, ok method name value bad
@Path("/config")
public class Param_String_JO_MtdOk_ValBad {
	
	@Inject
	@ConfigJson(classMember = "joms")
	private TypedProperty<String> test;
	
	
	@Path("/jsonObjectMemberMethodParemeterStringNameOkValBad")
	@GET
	public Response testGet() {
		return Response.ok("Parameterized type String, ok method name value bad: " + test).build();
	}
	
	@Path("/jsonObjectMemberMethodParemeterStringNameOkValBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<String> testGetTest() {
		return test;
	}
	
	public String joms() {
		return "{\"strMethodKey1\" : \"strMethodVal1\", \"strMethodKey2\": \"strMethodVa2\"";
	}
}