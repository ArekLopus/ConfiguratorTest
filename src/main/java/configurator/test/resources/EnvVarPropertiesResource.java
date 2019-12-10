package configurator.test.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/setEnvVar/testName-TestValue
// curl -i http://localhost:8080/ConfiguratorTest/res/config/removeEnvVar/testName

@Path("/config")
public class EnvVarPropertiesResource {
	
	@Path("/setEnvVar/{name}-{value}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response setEnvVar(@PathParam("name") String name, @PathParam("value") String value) throws Exception {
		TestHelper.setEnv(name, value);
		return Response.ok("ENV var set, name: " + name + ", value:" + value).build();
	}
	
	@Path("/removeEnvVar/{name}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response romoveEnvVar(@PathParam("name") String name) throws Exception {
		TestHelper.removeEnv(name);
		return Response.ok("ENV var removed, name: " + name).build();
	}
}