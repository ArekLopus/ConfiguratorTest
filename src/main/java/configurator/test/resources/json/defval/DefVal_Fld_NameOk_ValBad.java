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

// curl -i http://localhost:8080/ConfiguratorTest/res/config/DefValFieldNameOkValueBad

// Default value class member field name ok value bad
@Path("/config")
public class DefVal_Fld_NameOk_ValBad {
	
	String jos = "{\"error\" : \"String - There was an error loading value.\"";
	
	@Inject
	//@ConfigJson(property = "jsonObject", defaultValueIsClassMember = "jo")
	@ConfigJson(defaultValueIsClassMember = "jos")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/DefValFieldNameOkValueBad")
	@GET
	public Response testGet() {
		return Response.ok("Default value class member field name ok value bad: " + test).build();
	}
	
	@Path("/DefValFieldNameOkValueBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
}