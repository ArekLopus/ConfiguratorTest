package configurator.test.resources.json.defval;

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

// curl -i http://localhost:8080/ConfiguratorTest/res/config/DefValFieldNameBad

// Default value class member field name bad
@Path("/config")
public class DefVal_Fld_NameBad {
	
	JsonObject jo = Json.createObjectBuilder().add("objDefValKey1", "objDefValVal1").add("objDefValKey2", "objDefValVal2").build();
	
	@Inject
	//@ConfigJson(property = "jsonObject", defaultValueIsClassMember = "jo")
	@ConfigJson(defaultValueIsClassMember = "joBad")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/DefValFieldNameBad")
	@GET
	public Response testGet() {
		return Response.ok("Default value class member field name bad: " + test).build();
	}
	
	@Path("/DefValFieldNameBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
}