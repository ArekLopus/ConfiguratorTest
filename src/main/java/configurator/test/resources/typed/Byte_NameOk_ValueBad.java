package configurator.test.resources.typed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigTyped;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedParameterByteNameOkValueBad

// Byte typed property, name ok value bad
@Path("/config")
public class Byte_NameOk_ValueBad {
	
	@Inject
	@ConfigTyped(value = "testFilePropByteBad")
	private TypedProperty<Byte> test;
	
	
	@Path("/typedParameterByteNameOkValueBad")
	@GET
	public Response testGet() {
		return Response.ok("Byte typed property, name ok value bad: " + test).build();
	}
	
	@Path("/typedParameterByteNameOkValueBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<Byte> testGetTest() {
		return test;
	}
}