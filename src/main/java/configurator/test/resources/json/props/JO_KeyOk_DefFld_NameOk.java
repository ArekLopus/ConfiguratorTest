package configurator.test.resources.json.props;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectPropKeyOkDefFieldNameOk

// Ok JsonObject property key with default value class member field name ok
@Path("/config")
public class JO_KeyOk_DefFld_NameOk {
	
	JsonObject jo = Json.createObjectBuilder().add("error", "Field - There was an error loading value.").build();
	
	@Inject
	@ConfigJson(property = "jsonObjectProp", defaultValueIsClassMember = "jo")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/jsonObjectPropKeyOkDefFieldNameOk")
	@GET
	public Response testGet() {
		return Response.ok("Ok JsonObject property key with default value class member field name ok: " + test).build();
	}
	
	@Path("/jsonObjectPropKeyOkDefFieldNameOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
}