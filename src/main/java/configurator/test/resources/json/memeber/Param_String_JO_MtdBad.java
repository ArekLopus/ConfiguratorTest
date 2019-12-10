package configurator.test.resources.json.memeber;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectMemberMethodParemeterStringNameBad

// Parameterized type String, method name bad
@Path("/config")
public class Param_String_JO_MtdBad {
	
	@Inject
	@ConfigJson(classMember = "MethodNameBad")
	private TypedProperty<String> test;
	
	
	@Path("/jsonObjectMemberMethodParemeterStringNameBad")
	@GET
	public Response testGet() {
		return Response.ok("Parameterized type String, method name bad: " + test).build();
	}
	
	@Path("/jsonObjectMemberMethodParemeterStringNameBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<String> testGetTest() {
		return test;
	}
	
	public String joms() {
		return "{\"strMethodKey1\" : \"strMethodVal1\", \"strMethodKey2\": \"strMethodVa2\"}";
	}
}