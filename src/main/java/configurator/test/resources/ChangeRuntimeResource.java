package configurator.test.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.ConfiguratorSettings;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/getRuntime
// curl -i http://localhost:8080/ConfiguratorTest/res/config/changeRuntime?runtime=true
// curl -i http://localhost:8080/ConfiguratorTest/res/config/changeRuntime/true

@Path("/config")
public class ChangeRuntimeResource {
	
	@Path("/getRuntime")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public boolean getRuntime() {
		return ConfiguratorSettings.getInstance().isRuntimeCheck();
	}
	
	@Path("/changeRuntime")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response testGet(@QueryParam("runtime") Boolean setRuntime) {
		boolean runtimeCheckBefore = ConfiguratorSettings.getInstance().isRuntimeCheck();
		ConfiguratorSettings.getInstance().setRuntimeCheck(setRuntime);
		boolean runtimeCheckAfter = ConfiguratorSettings.getInstance().isRuntimeCheck();
		return Response.ok("Runtime before change: " + runtimeCheckBefore + ", Runtime after change:" + runtimeCheckAfter).build();
	}
	
	
	@Path("/changeRuntime/{runtime}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response basicPathParams(@PathParam("runtime") Boolean setRuntime) {
		boolean runtimeCheckBefore = ConfiguratorSettings.getInstance().isRuntimeCheck();
		ConfiguratorSettings.getInstance().setRuntimeCheck(setRuntime);
		boolean runtimeCheckAfter = ConfiguratorSettings.getInstance().isRuntimeCheck();
		return Response.ok("Runtime before change: " + runtimeCheckBefore + ", Runtime after change:" + runtimeCheckAfter).build();
	}
	
}