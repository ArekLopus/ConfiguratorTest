package configurator.test.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/setSystemProp/testName-TestValue
// curl -i http://localhost:8080/ConfiguratorTest/res/config/removeSystemProp/testName

@Path("/config")
public class SystemPropertiesResource {
	
	@Path("/setSystemProp/{name}-{value}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response setEnvVar(@PathParam("name") String name, @PathParam("value") String value) throws Exception {
		System.setProperty(name, value);
		return Response.ok("System property set, name: " + name + ", value:" + value).build();
	}
	
	@Path("/removeSystemProp/{name}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response romoveEnvVar(@PathParam("name") String name) throws Exception {
		System.clearProperty(name);
		return Response.ok("System property removed, name: " + name).build();
	}
}