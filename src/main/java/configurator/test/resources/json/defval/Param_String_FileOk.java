package configurator.test.resources.json.defval;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/StringFileNameOk

// Parameterized type String, default value file name ok
@Path("/config")
public class Param_String_FileOk {
	
	@Inject
	//@ConfigJson(filePath = "/config/configObject.json", defaultValueFile = "/config/configObjectDefVal.json")
	@ConfigJson(defaultValueFile = "/config/configObjectDefVal.json")
	private TypedProperty<String> test;
	
	
	@Path("/StringFileNameOk")
	@GET
	public Response testGet() {
		return Response.ok("Parameterized type String, default value file name ok: " + test).build();
	}
	
	@Path("/StringFileNameOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<String> testGetTest() {
		return test;
	}
}