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

// curl -i http://localhost:8080/ConfiguratorTest/res/config/DefValFifeNameOk

// Default value file name ok
@Path("/config")
public class DefVal_File_NameOk {
	
	@Inject
	//@ConfigJson(property = "jsonObject", defaultValueFile = "/config/configObjectDefVal.json")
	@ConfigJson(defaultValueFile = "/config/configObjectDefVal.json")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/DefValFifeNameOk")
	@GET
	public Response testGet() {
		return Response.ok("Default value file name ok: " + test).build();
	}
	
	@Path("/DefValFifeNameOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
}