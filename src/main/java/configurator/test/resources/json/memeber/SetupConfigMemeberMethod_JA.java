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

// curl -i http://localhost:8080/ConfiguratorTest/res/config/setupJsonArrayMethodOk

// Class members setup in @ConfiguratorSetup are accessed using fullyQualifiedClassName.memberName (here configurator.json.test.TestSetup.jam)
@Path("/config")
public class SetupConfigMemeberMethod_JA {
	
	@Inject
	@ConfigJson(property = "configurator.json.test.TestSetup.jam")
	private TypedProperty<JsonArray> test;
	
	
	@Path("/setupJsonArrayMethodOk")
	@GET
	public Response testGet() {
		return Response.ok("Class members setup in @ConfiguratorSetup are accessed using fullyQualifiedClassName.memberName (here configurator.json.test.TestSetup.jam): " + test).build();
	}
	
	@Path("/setupJsonArrayMethodOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonArray> testGetTest() {
		return test;
	}
	
}