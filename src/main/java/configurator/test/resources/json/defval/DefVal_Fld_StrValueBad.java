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

// curl -i http://localhost:8080/ConfiguratorTest/res/config/DefValFieldStrValueBad

// Default value class member field String value bad
@Path("/config")
public class DefVal_Fld_StrValueBad {
	
	String jos = "{\"error\" : \"Field - There was an error loading value.\"";
	
	@Inject
	//@ConfigJson(property = "jsonObject", defaultValueIsClassMember = "jos")
	@ConfigJson(defaultValueIsClassMember = "jos")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/DefValFieldStrValueBad")
	@GET
	public Response testGet() {
		return Response.ok("Default value class member field String value bad: " + test).build();
	}
	
	@Path("/DefValFieldStrValueBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
}