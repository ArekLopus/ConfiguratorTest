package configurator.test;

import javax.enterprise.context.ApplicationScoped;
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

// curl http://localhost:8080/ConfiguratorTest/res/config/jsonObjectAppScopedCdi
// curl http://localhost:8080/ConfiguratorTest/res/json/changeObject

// There is only one instance of CDI bean @ApplicationScoped - no reloads
@Path("/config")
@ApplicationScoped
public class ResourceBeanAppScope {
	
	@Inject
	@ConfigJson(url = "http://localhost:8080/ConfiguratorTest/res/json/object", runtimeCheck = RuntimeCheckType.YES)
	TypedProperty<JsonObject> test;
	
	
	@Path("/jsonObjectAppScopedCdi")
	@GET
	public Response testGet() {
		return Response.ok("There is only one instance of CDI bean @ApplicationScoped - no reloads: " + test).build();
	}
	
	@Path("/jsonObjectAppScopedCdi/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<JsonObject> testGetTest() {
		return test;
	}
}
