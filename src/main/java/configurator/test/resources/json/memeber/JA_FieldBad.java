package configurator.test.resources.json.memeber;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonArrayFieldNameBad

// Field class member name bad
@Path("/config")
public class JA_FieldBad {
	
	JsonArray ja = Json.createArrayBuilder().add("arrObjFieldVal1").add("arrObjFieldVal2").build();
	String jas = "[\"arrStrFieldVal1\", \"arrStrFieldVal2\"]";
	
	@Inject
	@ConfigJson(classMember = "badFieldName")
	private TypedProperty<JsonArray> test;
	
	
	@Path("/jsonArrayFieldNameBad")
	@GET
	public Response testGet() {
		return Response.ok("Field class member name bad: " + test).build();
	}
	
	@Path("/jsonArrayFieldNameBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonArray> testGetTest() {
		return test;
	}
}