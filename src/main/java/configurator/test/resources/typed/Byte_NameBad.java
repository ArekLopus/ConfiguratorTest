package configurator.test.resources.typed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigTyped;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedParameterByteNameBad

// Byte typed property, name bad
@Path("/config")
public class Byte_NameBad {
	
	@Inject
	@ConfigTyped("ByteBadPropertyName")
	private TypedProperty<Byte> test;
	
	
	@Path("/typedParameterByteNameBad")
	@GET
	public Response testGet() {
		return Response.ok("Byte typed property, name bad: " + test).build();
	}
	
	@Path("/typedParameterByteNameBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<Byte> testGetTest() {
		return test;
	}
}