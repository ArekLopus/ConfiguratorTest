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

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectFileOkDefPropNameOk

// Ok file name with default value property name ok
@Path("/config")
public class JO_FileOk_DefProp_NameOk {
	
	@Inject
	@ConfigJson(filePath = "/config/configObject.json", defaultValueProperty = "jsonObjectDefValProp")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/jsonObjectFileOkDefPropNameOk")
	@GET
	public Response testGet() {
		return Response.ok("Ok file name with default value property name ok: " + test).build();
	}
	
	@Path("/jsonObjectFileOkDefPropNameOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
}