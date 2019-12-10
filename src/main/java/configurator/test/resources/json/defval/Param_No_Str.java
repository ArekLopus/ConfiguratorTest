package configurator.test.resources.json.defval;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/stringDefaultValueParemeterNo

// No parameter for String from default value
@Path("/config")
@SuppressWarnings("rawtypes")
public class Param_No_Str {
	
	@Inject
	@ConfigJson(defaultValue = "{\"error\" : \"String - There was an error loading value.\"}")
	private TypedProperty test;
	
	
	@Path("/stringDefaultValueParemeterNo")
	@GET
	public Response testGet() {
		return Response.ok("No parameter for JsonObject from default value: " + test).build();
	}
	
	@Path("/stringDefaultValueParemeterNo/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty testGetTest() {
		return test;
	}
}