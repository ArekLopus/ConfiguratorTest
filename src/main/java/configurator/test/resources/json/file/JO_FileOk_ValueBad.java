package configurator.test.resources.json.file;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectFileOkValueBad

// Ok file name value bad
@Path("/config")
public class JO_FileOk_ValueBad {
	
	@Inject
	@ConfigJson(filePath = "/config/configObjectBad.json")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/jsonObjectFileOkValueBad")
	@GET
	public Response testGet() {
		return Response.ok("Ok file name value bad: " + test).build();
	}
	
	
	@Path("/jsonObjectFileOkValueBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
	
}