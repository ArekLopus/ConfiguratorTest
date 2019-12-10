package configurator.test.resources.json.url;

import javax.inject.Inject;
import javax.json.JsonArray;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonArrayUrlOkValueBad

// Ok URL value bad
@Path("/config")
public class JA_UrlOk_ValBad {
	
	@Inject
	@ConfigJson(url = "http://localhost:8080/ConfiguratorTest/res/json/arrayBad")
	private TypedProperty<JsonArray> test;
	
	
	@Path("/jsonArrayUrlOkValueBad")
	@GET
	public Response testGet() {
		return Response.ok("Ok URL value bad: " + test).build();
	}
	
	@Path("/jsonArrayUrlOkValueBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonArray> testGetTest() {
		return test;
	}
}