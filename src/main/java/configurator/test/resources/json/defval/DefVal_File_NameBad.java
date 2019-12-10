package configurator.test.resources.json.defval;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/DefValFifeNameBad

// Default value file name bad
@Path("/config")
public class DefVal_File_NameBad {
	
	@Inject
	//@ConfigJson(property = "jsonObject", defaultValueFile = "/config/configObjectDefVal.jsonBad")
	@ConfigJson(defaultValueFile = "/config/configObjectDefVal.jsonBaDFileName")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/DefValFifeNameBad")
	@GET
	public Response testGet() {
		return Response.ok("Default value file name bad: " + test).build();
	}
	
	@Path("/DefValFifeNameBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
}