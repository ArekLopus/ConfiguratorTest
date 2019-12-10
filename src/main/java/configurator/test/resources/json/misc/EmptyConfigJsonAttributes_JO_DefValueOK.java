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

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectEmptyValueAttributeDefVal

// Empty value attribute with default value
@Path("/config")
public class EmptyConfigJsonAttributes_JO_DefValueOK {
	
	@Inject
	@ConfigJson(defaultValue = "{\"error\" : \"String - There was an error loading value.\"}")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/jsonObjectEmptyValueAttributeDefVal")
	@GET
	public Response testGet() {
		return Response.ok("Empty value attribute with default value: " + test).build();
	}
	
	@Path("/jsonObjectEmptyValueAttributeDefVal/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
}