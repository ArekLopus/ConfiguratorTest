package configurator.test.resources.json.misc;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectMultiValueAttributeDefVal2

// Empty value attribute
@Path("/config")
public class MultiConfigJsonAttributes_JO_DefValOk2 {
	
	@Inject
	@ConfigJson(defaultValueProperty = "jsonObjectDefValProp", defaultValueFile = "/config/configObjectDefVal.json")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/jsonObjectMultiValueAttributeDefVal2")
	@GET
	public Response testGet() {
		return Response.ok("Empty value attribute: " + test).build();
	}
	
	@Path("/jsonObjectMultiValueAttributeDefVal2/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
}