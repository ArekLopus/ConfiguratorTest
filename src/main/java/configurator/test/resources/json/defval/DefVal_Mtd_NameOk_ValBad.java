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

// curl -i http://localhost:8080/ConfiguratorTest/res/config/DefValMethodNameOkValueBad

// Default value class member method name ok value bad
@Path("/config")
public class DefVal_Mtd_NameOk_ValBad {
	
	@Inject
	//@ConfigJson(property = "jsonObject", defaultValueIsClassMember = "jo")
	@ConfigJson(defaultValueIsClassMember = "joms")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/DefValMethodNameOkValueBad")
	@GET
	public Response testGet() {
		return Response.ok("Default value class member method name ok value bad: " + test).build();
	}
	
	@Path("/DefValMethodNameOkValueBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
	
	public String joms() {
		return "{\"error\" : \"String - There was an error loading value.\"";
	}
}