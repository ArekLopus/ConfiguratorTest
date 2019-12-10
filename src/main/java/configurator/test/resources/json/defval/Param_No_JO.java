package configurator.test.resources.json.defval;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectDefaultValueParemeterNo

// No parameter for JsonObject from default value
@Path("/config")
@SuppressWarnings("rawtypes")
public class Param_No_JO {
	
	JsonObject jo = Json.createObjectBuilder().add("error", "Field - There was an error loading value.").build();
	
	@Inject
	@ConfigJson(defaultValueIsClassMember = "jo")
	private TypedProperty test;
	
	
	@Path("/jsonObjectDefaultValueParemeterNo")
	@GET
	public Response testGet() {
		return Response.ok("No parameter for JsonObject from default value: " + test).build();
	}
	
	@Path("/jsonObjectDefaultValueParemeterNo/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty testGetTest() {
		return test;
	}
}