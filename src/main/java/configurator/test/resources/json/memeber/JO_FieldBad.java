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

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectFieldNameBad

// Field class member name bad
@Path("/config")
public class JO_FieldBad {
	
	@Inject
	@ConfigJson(classMember = "badFieldName")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/jsonObjectFieldNameBad")
	@GET
	public Response testGet() {
		return Response.ok("Field class member name bad: " + test).build();
	}
	
	@Path("/jsonObjectFieldNameBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
}