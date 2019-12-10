package configurator.test.resources.json.file;

import javax.inject.Inject;
import javax.json.JsonArray;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonArrayFileOkValueBad

// Ok file name
@Path("/config")
public class JA_FileOk_ValBad {
	
	@Inject
	@ConfigJson(filePath = "/config/configArrayBad.json")
	private TypedProperty<JsonArray> test;
	
	
	@Path("/jsonArrayFileOkValueBad")
	@GET
	public Response testGet() {
		return Response.ok("Ok file name: " + test).build();
	}
	
	@Path("/jsonArrayFileOkValueBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonArray> testGetTest() {
		return test;
	}
}