package configurator.test.resources.json.file;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/StringParamFileNameBad

// Parameterized type String, file name bad
@Path("/config")
public class Param_String_FileBad {
	
	@Inject
	@ConfigJson(filePath = "FileNameBad")
	private TypedProperty<String> test;
	
	
	@Path("/StringParamFileNameBad")
	@GET
	public Response testGet() {
		return Response.ok("Parameterized type String, file name bad: " + test).build();
	}
	
	
	@Path("/StringParamFileNameBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<String> testGetTest() {
		return test;
	}
	
}