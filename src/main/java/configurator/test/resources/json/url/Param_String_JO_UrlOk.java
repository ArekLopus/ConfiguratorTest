package configurator.test.resources.json.url;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectUrlParameterStringUrlOk

// Parameterized type String for JsonObject, URL ok
@Path("/config")
public class Param_String_JO_UrlOk {
	
	@Inject
	@ConfigJson(url = "http://localhost:8080/ConfiguratorTest/res/json/object")
	private TypedProperty<String> test;
	
	
	@Path("/jsonObjectUrlParameterStringUrlOk")
	@GET
	public Response testGet() {
		return Response.ok("Parameterized type String for JsonObject, URL ok: " + test).build();
	}
	
	@Path("/jsonObjectUrlParameterStringUrlOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<String> testGetTest() {
		return test;
	}
}