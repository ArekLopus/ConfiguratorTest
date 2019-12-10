package configurator.test;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;
import configurator.enums.RuntimeCheckType;

// curl http://localhost:8080/ConfiguratorTest/res/config/jsonObjectReqScopedCdi
// curl http://localhost:8080/ConfiguratorTest/res/json/changeObject

// @RequestScoped beans are created for every requests
@Path("/config")
@RequestScoped
public class ResourceBeanReqScope {
	
	@Inject
	@ConfigJson(url = "http://localhost:8080/ConfiguratorTest/res/json/object", runtimeCheck = RuntimeCheckType.YES)
	TypedProperty<JsonObject> test;
	
	
	@Path("/jsonObjectReqScopedCdi")
	@GET
	public Response testGet() {
		return Response.ok("@RequestScoped beans are created for every requests: " + test).build();
	}
	
	@Path("/jsonObjectReqScopedCdi/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
}
