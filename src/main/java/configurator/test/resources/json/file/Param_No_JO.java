package configurator.test.resources.json.file;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectFileParemeterNo

// No parameter for JsonObject from file
@Path("/config")
@SuppressWarnings("rawtypes")
public class Param_No_JO {
	
	@Inject
	@ConfigJson(filePath = "/config/configObject.json")
	private TypedProperty test;
	
	
	@Path("/jsonObjectFileParemeterNo")
	@GET
	public Response testGet() {
		return Response.ok("No parameter for JsonObject from file: " + test).build();
	}
	
	@Path("/jsonObjectFileParemeterNo/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty testGetTest() {
		return test;
	}
}