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

// curl -i http://localhost:8080/ConfiguratorTest/res/config/DefValPropertyNameOk

// Default value property name ok
@Path("/config")
public class DefVal_Prop_NameOk {
	
	@Inject
	//@ConfigJson(property = "jsonObject", defaultValueProperty = "jsonObjectDefValProp")
	@ConfigJson(defaultValueProperty = "jsonObjectDefValProp")
	private TypedProperty<JsonObject> test;
	
	
	@Path("/DefValPropertyNameOk")
	@GET
	public Response testGet() {
		return Response.ok("Default value property name ok: " + test).build();
	}
	
	@Path("/DefValPropertyNameOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
}