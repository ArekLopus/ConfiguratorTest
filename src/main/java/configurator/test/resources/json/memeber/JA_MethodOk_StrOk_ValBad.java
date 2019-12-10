package configurator.test.resources.json.memeber;

import javax.inject.Inject;
import javax.json.JsonArray;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonArrayMethodStrNameOkValueBad

// Method class member String name ok
@Path("/config")
public class JA_MethodOk_StrOk_ValBad {
	
	@Inject
	@ConfigJson(classMember = "jams")
	private TypedProperty<JsonArray> test;
	
	
	@Path("/jsonArrayMethodStrNameOkValueBad")
	@GET
	public Response testGet() {
		return Response.ok("Method class member String name ok: " + test).build();
	}
	
	@Path("/jsonArrayMethodStrNameOkValueBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonArray> testGetTest() {
		return test;
	}
	
	public String jams() {
		return "[\"arrStrMetVal1\", \"arrStrMetVal2\"";
	}
	
}