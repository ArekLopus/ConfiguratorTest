package configurator.test.resources.json.props;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectPropKeyOkDefFileNameOk

// Ok JsonObject property key with default value file name ok
@Path("/config")
public class JO_KeyOk_DefFile_NameOk {
	
	@Inject
	@ConfigJson(property = "jsonObjectProp", defaultValueFile = "/config/configObjectDefVal.json")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/jsonObjectPropKeyOkDefFileNameOk")
	@GET
	public Response testGet() {
		return Response.ok("Ok JsonObject property key with default value file name ok: " + test).build();
	}
	
	@Path("/jsonObjectPropKeyOkDefFileNameOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
}