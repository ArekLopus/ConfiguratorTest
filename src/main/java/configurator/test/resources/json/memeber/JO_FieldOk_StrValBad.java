package configurator.test.resources.json.memeber;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectFieldOkStrValueBad

// Field class member String value bad
@Path("/config")
public class JO_FieldOk_StrValBad {
	
	String jos = "{\"strFieldKey1\" : \"strFieldVal1\", \"strFieldKey2\": \"strFieldVa2\"";
	
	@Inject
	@ConfigJson(classMember = "jos")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/jsonObjectFieldOkStrValueBad")
	@GET
	public Response testGet() {
		return Response.ok("Field class member String value bad: " + test).build();
	}
	
	@Path("/jsonObjectFieldOkStrValueBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
}