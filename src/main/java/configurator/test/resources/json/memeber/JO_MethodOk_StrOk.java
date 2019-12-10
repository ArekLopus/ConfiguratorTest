package configurator.test.resources.json.memeber;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectMethodStrNameOk

// Method class member String value ok
@Path("/config")
public class JO_MethodOk_StrOk {
	
	@Inject
	@ConfigJson(classMember = "joms")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/jsonObjectMethodStrNameOk")
	@GET
	public Response testGet() {
		return Response.ok("Method class member String value ok: " + test).build();
	}
	
	@Path("/jsonObjectMethodStrNameOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
	
	public String joms() {
		return "{\"strMethodKey1\" : \"strMethodVal1\", \"strMethodKey2\": \"strMethodVa2\"}";
	}
	
}