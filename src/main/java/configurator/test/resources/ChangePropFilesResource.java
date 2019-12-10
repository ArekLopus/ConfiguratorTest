package configurator.test.resources;

import java.util.HashSet;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import configurator.ConfiguratorSettings;
import configurator.typed.LoaderProperties;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/getPropFile
// curl -i http://localhost:8080/ConfiguratorTest/res/config/getAllProps
// curl -i http://localhost:8080/ConfiguratorTest/res/config/changePropFileToNewPaths
// curl -i http://localhost:8080/ConfiguratorTest/res/config/changePropFileToOldPaths

@Path("/config")
@ApplicationScoped
public class ChangePropFilesResource {
	
	private static ConfiguratorSettings settings = ConfiguratorSettings.getInstance();
	
	
	@Path("/getOldPaths")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public HashSet<String> getOldPaths() {
		return settings.getPropertiesPaths();
	}
	@Path("/setNewPaths")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String setNewPaths(HashSet<String> paths) {
		System.err.println("Got paths:" + paths);
		settings.getPropertiesPaths().clear();
		settings.setPropertiesPaths(paths);
		return "Got paths:" + paths;
	}
	
	@Path("/setOldPaths")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String setOldPaths(HashSet<String> paths) {
		System.err.println("Got paths:" + paths);
//		settings.getLoadedProperties().clear();
		settings.getPropertiesPaths().clear();
		settings.setPropertiesPaths(paths);
		LoaderProperties.loadPropertiesFromFile(paths);
		return "Got paths:" + paths;
	}
	
	
	@Path("/getAllProps")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getProps() {
		return ConfiguratorSettings.getInstance().getLoadedProperties().toString();
	}
	@Path("/clearProps")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String clrProps() {
		ConfiguratorSettings.getInstance().getLoadedProperties().clear();
		return "Props cleared";
	}
}