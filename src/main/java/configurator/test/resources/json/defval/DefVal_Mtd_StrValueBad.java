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

// curl -i http://localhost:8080/ConfiguratorTest/res/config/DefValMethodStrValueBad

// Default value class member method String value bad
@Path("/config")
public class DefVal_Mtd_StrValueBad {
	
	@Inject
	//@ConfigJson(property = "jsonObject", defaultValueIsClassMember = "joms")
	@ConfigJson(defaultValueIsClassMember = "joms")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/DefValMethodStrValueBad")
	@GET
	public Response testGet() {
		return Response.ok("Default value class member method String value bad: " + test).build();
	}
	
	@Path("/DefValMethodStrValueBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
	
	public String joms() {
		return "{\"error\" : \"Method - There was an error loading value.\"";
	}
}