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

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectFileBad

// Bad file name
@Path("/config")
public class JO_FileBad {
		
	@Inject
	@ConfigJson(filePath = "/config/configObjectBadName.json")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/jsonObjectFileBad")
	@GET
	public Response testGet() {
		return Response.ok("Bad file name: " + test).build();
	}
	
	
	@Path("/jsonObjectFileBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
	
}