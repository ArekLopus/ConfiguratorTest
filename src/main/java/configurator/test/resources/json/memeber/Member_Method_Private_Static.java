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

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectMethodPrivateStatic

// Ok method member private static
@Path("/config")
public class Member_Method_Private_Static {
	
	@Inject
	@ConfigJson(classMember = "jom")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/jsonObjectMethodPrivateStatic")
	@GET
	public Response testGet() {
		return Response.ok("Ok method member private static: " + test).build();
	}
	
	@Path("/jsonObjectMethodPrivateStatic/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
	
	
	@SuppressWarnings("unused")
	private static JsonObject jom() {
		return Json.createObjectBuilder().add("objMethodKey1", "objMethodVal1").add("objMethodKey2", "objMethodVal2").build();
	}
	
}