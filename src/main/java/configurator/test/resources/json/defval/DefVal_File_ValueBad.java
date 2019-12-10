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

// curl -i http://localhost:8080/ConfiguratorTest/res/config/DefValFifeValueBad

// Default value file name ok value bad
@Path("/config")
public class DefVal_File_ValueBad {
	
	@Inject
	//@ConfigJson(property = "jsonObject", defaultValueFile = "/config/configObjectDefValBad.json")
	@ConfigJson(defaultValueFile = "/config/configObjectDefValBad.json")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/DefValFifeValueBad")
	@GET
	public Response testGet() {
		return Response.ok("Default value file name ok value bad: " + test).build();
	}
	
	@Path("/DefValFifeValueBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
}