package configurator.test.resources.json.memeber;

import javax.inject.Inject;
import javax.json.JsonArray;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonArrayMethodNameBad

// Method class member array object name bad
@Path("/config")
public class JA_MethodBad {
	
	@Inject
	@ConfigJson(classMember = "badMethodName")
	private TypedProperty<JsonArray> test;
	
	
	@Path("/jsonArrayMethodNameBad")
	@GET
	public Response testGet() {
		return Response.ok("Method class member array object name bad: " + test).build();
	}
	
	@Path("/jsonArrayMethodNameBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonArray> testGetTest() {
		return test;
	}
	
}