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

// curl -i http://localhost:8080/ConfiguratorTest/res/config/StringMethodNameOk

// Parameterized type String, default value class member method name ok
@Path("/config")
public class Param_String_MtdOk {
	
	@Inject
//	@ConfigJson(classMember = "jo", defaultValueIsClassMember = "jodv")
	@ConfigJson(defaultValueIsClassMember = "jom")
	private TypedProperty<String> test;
	
	
	@Path("/StringMethodNameOk")
	@GET
	public Response testGet() {
		return Response.ok("Parameterized type String, default value class member method name ok: " + test).build();
	}
	
	@Path("/StringMethodNameOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<String> testGetTest() {
		return test;
	}
	
	public JsonObject jom() {
		return Json.createObjectBuilder().add("error", "Method - There was an error loading value.").build();
	}
}