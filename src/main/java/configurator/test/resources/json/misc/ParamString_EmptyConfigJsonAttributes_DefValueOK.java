package configurator.test.resources.json.misc;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/stringEmptyValueAttributeDefVal

// Parameterized type String, empty value attribute with default value
@Path("/config")
public class ParamString_EmptyConfigJsonAttributes_DefValueOK {
	
	@Inject
	@ConfigJson(defaultValue = "{\"error\" : \"String - There was an error loading value.\"}")
	private TypedProperty<String> test;
	
	
	@Path("/stringEmptyValueAttributeDefVal")
	@GET
	public Response testGet() {
		return Response.ok("Parameterized type String, empty value attribute with default value: " + test).build();
	}
	
	@Path("/stringEmptyValueAttributeDefVal/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<String> testGetTest() {
		return test;
	}
}