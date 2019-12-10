package configurator.test.resources.json.url;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectUrlOkValueBad

// Ok URL JsonObject value bad
@Path("/config")
public class JO_UrlOk_ValueBad {
	
	@Inject
	@ConfigJson(url = "http://localhost:8080/ConfiguratorTest/res/json/objectBad")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/jsonObjectUrlOkValueBad")
	@GET
	public Response testGet() {
		return Response.ok("Ok URL JsonObject value bad: " + test).build();
	}
	
	@Path("/jsonObjectUrlOkValueBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
}