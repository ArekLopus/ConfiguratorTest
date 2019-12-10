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

// curl -i http://localhost:8080/ConfiguratorTest/res/config/DefValMethodNameBad

// Default value class member method name bad
@Path("/config")
public class DefVal_Mtd_NameBad {
	
	@Inject
	//@ConfigJson(property = "jsonObject", defaultValueIsClassMember = "jo")
	@ConfigJson(defaultValueIsClassMember = "methodBadName")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/DefValMethodNameBad")
	@GET
	public Response testGet() {
		return Response.ok("Default value class member method name bad: " + test).build();
	}
	
	@Path("/DefValMethodNameBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
	
	public JsonObject jom() {
		return Json.createObjectBuilder().add("error", "Method - There was an error loading value.").build();
	}
}