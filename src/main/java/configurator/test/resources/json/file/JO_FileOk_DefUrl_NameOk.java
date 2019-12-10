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

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectFileOkDefUrlNameOk

// Ok file name with default value url name ok
@Path("/config")
public class JO_FileOk_DefUrl_NameOk {
	
	@Inject
	@ConfigJson(filePath = "/config/configObject.json", defaultValueUrl = "http://localhost:8080/ConfiguratorTest/res/json/objectDefVal")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/jsonObjectFileOkDefUrlNameOk")
	@GET
	public Response testGet() {
		return Response.ok("Ok file name with default value url name ok: " + test).build();
	}
	
	@Path("/jsonObjectFileOkDefUrlNameOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
}