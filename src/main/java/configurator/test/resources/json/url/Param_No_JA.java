package configurator.test.resources.json.url;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonArrayUrlParemeterNo

// No parameter for JsonArray
@Path("/config")
@SuppressWarnings("rawtypes")
public class Param_No_JA {
	
	@Inject
	@ConfigJson(url = "http://localhost:8080/ConfiguratorTest/res/json/array")
	private TypedProperty test;
	
	
	@Path("/jsonArrayUrlParemeterNo")
	@GET
	public Response testGet() {
		return Response.ok("No parameter for JsonArray: " + test).build();
	}
	
	@Path("/jsonArrayUrlParemeterNo/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty testGetTest() {
		return test;
	}
}