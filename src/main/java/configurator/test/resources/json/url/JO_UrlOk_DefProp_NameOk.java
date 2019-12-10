package configurator.test.resources.json.url;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectUrlOkDefValPropNameOk

// Ok URL with default value property name ok
@Path("/config")
public class JO_UrlOk_DefProp_NameOk {
	
	@Inject
	@ConfigJson(url = "http://localhost:8080/ConfiguratorTest/res/json/object", defaultValueProperty = "jsonObjectDefValProp")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/jsonObjectUrlOkDefValPropNameOk")
	@GET
	public Response testGet() {
		return Response.ok("Ok URL with default value property name ok: " + test).build();
	}
	
	@Path("/jsonObjectUrlOkDefValPropNameOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
}