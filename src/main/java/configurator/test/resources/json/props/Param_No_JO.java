package configurator.test.resources.json.props;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/jsonObjectPropParemeterNo

// No parameter for JsonObject from property
@Path("/config")
@SuppressWarnings("rawtypes")
public class Param_No_JO {
	
	@Inject
	@ConfigJson(property = "jsonObjectProp")
	private TypedProperty test;
	
	
	@Path("/jsonObjectPropParemeterNo")
	@GET
	public Response testGet() {
		return Response.ok("No parameter for JsonObject from property: " + test).build();
	}
	
	@Path("/jsonObjectPropParemeterNo/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty testGetTest() {
		return test;
	}
}