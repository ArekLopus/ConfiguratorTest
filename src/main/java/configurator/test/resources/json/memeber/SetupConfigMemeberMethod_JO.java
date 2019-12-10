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

// curl -i http://localhost:8080/ConfiguratorTest/res/config/setupJsonObjectMethodOk

// Class members setup in @ConfiguratorSetup are accessed using fullyQualifiedClassName.memberName (here configurator.json.test.TestSetup.jom)
@Path("/config")
public class SetupConfigMemeberMethod_JO {
	
	@Inject
	@ConfigJson(property = "configurator.json.test.TestSetup.jom")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/setupJsonObjectMethodOk")
	@GET
	public Response testGet() {
		return Response.ok("Class members setup in @ConfiguratorSetup are accessed using fullyQualifiedClassName.memberName (here configurator.json.test.TestSetup.jom): " + test).build();
	}
	
	@Path("/setupJsonObjectMethodOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
	
}