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

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectFileBadDefValueOk

// Bad file name with default value ok
@Path("/config")
public class JO_FileBad_DefValueOk {
	
	@Inject
	@ConfigJson(filePath = "/config/configObject.jsonAaa", defaultValue = "{\"error\" : \"There was an error loading value.\"}")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/jsonObjectFileBadDefValueOk")
	@GET
	public Response testGet() {
		return Response.ok("Bad file name with default value ok: " + test).build();
	}
	
	@Path("/jsonObjectFileBadDefValueOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
}