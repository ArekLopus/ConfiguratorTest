package configurator.test.resources.json.url;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectUrlParemeterNo

// No parameter for JsonObject
@Path("/config")
@SuppressWarnings("rawtypes")
public class Param_No_JO {
	
	@Inject
	@ConfigJson(url = "http://localhost:8080/ConfiguratorTest/res/json/object")
	private TypedProperty test;
	
	
	@Path("/jsonObjectUrlParemeterNo")
	@GET
	public Response testGet() {
		return Response.ok("No parameter for JsonObject: " + test).build();
	}
	
	@Path("/jsonObjectUrlParemeterNo/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty testGetTest() {
		return test;
	}
}