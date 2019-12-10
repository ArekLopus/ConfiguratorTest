package configurator.test.resources.json.file;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/StringParamFileNameOk

// Parameterized type String, file name ok
@Path("/config")
public class Param_String_FileOk {
	
	@Inject
	@ConfigJson(filePath = "/config/configObject.json")
	private TypedProperty<String> test;
	
	
	@Path("/StringParamFileNameOk")
	@GET
	public Response testGet() {
		return Response.ok("Parameterized type String, file name ok: " + test).build();
	}
	
	
	@Path("/StringParamFileNameOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<String> testGetTest() {
		return test;
	}
	
}