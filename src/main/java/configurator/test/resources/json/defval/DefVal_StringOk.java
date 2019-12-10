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

// curl -i http://localhost:8080/ConfiguratorTest/res/config/DefValStringOk

// Default value (String) value ok
@Path("/config")
public class DefVal_StringOk {
	
	@Inject
//	@ConfigJson(property = "jsonObject", defaultValue = "{\"strDefValKey1\" : \"strDefValVal1\", \"strDefValKey2\": \"strDefValVal2\"}")
	@ConfigJson(defaultValue = "{\"error\" : \"String - There was an error loading value.\"}")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/DefValStringOk")
	@GET
	public Response testGet() {
		return Response.ok("Default value (String) value ok: " + test).build();
	}
	
	@Path("/DefValStringOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
}