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

// curl -i http://localhost:8080/ConfiguratorTest/res/config/DefValUrlNameOkValueBad

// Default value url name ok value bad
@Path("/config")
public class DefVal_Url_NameOk_ValBad {
	
	@Inject
	//@ConfigJson(property = "jsonObject", defaultValueUrl = "http://localhost:8080/ConfiguratorTest/res/json/objectDefVal")
	@ConfigJson(defaultValueUrl = "http://localhost:8080/ConfiguratorTest/res/json/objectDefValBad")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/DefValUrlNameOkValueBad")
	@GET
	public Response testGet() {
		return Response.ok("Default value url name ok value bad: " + test).build();
	}
	
	@Path("/DefValUrlNameOkValueBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
}