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

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectMethodOkWrongReturnTypeInt

// Method class member method name ok return type bad (Integer)
@Path("/config")
public class JO_MethodOk_WrongTypeInt {
	
	String jos = "{\"strFieldKey1\" : \"strFieldVal1\", \"strFieldKey2\": \"strFieldVa2\"}";
	
	@Inject
	@ConfigJson(classMember = "jom")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/jsonObjectMethodOkWrongReturnTypeInt")
	@GET
	public Response testGet() {
		return Response.ok("Method class member method name ok return type bad (Integer): " + test).build();
	}
	
	@Path("/jsonObjectMethodOkWrongReturnTypeInt/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
	
	public Integer jom() {
		return 42;
	}
	
}