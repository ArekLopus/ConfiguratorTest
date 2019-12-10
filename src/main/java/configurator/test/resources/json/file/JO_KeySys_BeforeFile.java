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

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectSysBeforeFile

// jsonObject from system is before file if the same names
@Path("/config")
public class JO_KeySys_BeforeFile {
	
	@Inject
	@ConfigJson(property = "jsonObject", defaultValue = "{\"bad\" : \"property key\", \"String\": \"As Default Value\"}")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/jsonObjectSysBeforeFile")
	@GET
	public Response testGet() {
		return Response.ok("jsonObject from system is before file if the same names: " + test).build();
	}
	
	@Path("/jsonObjectSysBeforeFile/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
}