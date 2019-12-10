package configurator.test.resources.json.memeber;

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

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectMemberFieldParemeterNo

// No parameter for JsonObject from field class member
@Path("/config")
@SuppressWarnings("rawtypes")
public class Param_No_JO_Field {
	
	JsonObject jo = Json.createObjectBuilder().add("objFieldKey1", "objFieldVal1").add("objFieldKey2", "objFieldVal2").build();
	
	@Inject
	@ConfigJson(classMember = "jo")
	private TypedProperty test;
	
	
	@Path("/jsonObjectMemberFieldParemeterNo")
	@GET
	public Response testGet() {
		return Response.ok("No parameter for JsonObject from field class member: " + test).build();
	}
	
	@Path("/jsonObjectMemberFieldParemeterNo/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty testGetTest() {
		return test;
	}
}