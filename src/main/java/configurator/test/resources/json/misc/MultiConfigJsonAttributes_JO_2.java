package configurator.test.resources.json.misc;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectMultiValueAttribute2

// Empty value attribute
@Path("/config")
public class MultiConfigJsonAttributes_JO_2 {
	
	@Inject
	@ConfigJson(filePath = "/config/configObject.json", url = "http://localhost:8080/ConfiguratorTest/res/json/object")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/jsonObjectMultiValueAttribute2")
	@GET
	public Response testGet() {
		return Response.ok("Empty value attribute: " + test).build();
	}
	
	@Path("/jsonObjectMultiValueAttribute2/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
}