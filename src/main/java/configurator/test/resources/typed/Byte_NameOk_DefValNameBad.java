package configurator.test.resources.typed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigTyped;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedParameterByteNameOkDefValBad

// Byte typed property, name ok default value bad
@Path("/config")
public class Byte_NameOk_DefValNameBad {
	
	@Inject
	@ConfigTyped(value = "testFilePropByte", defaultValue = "valueBad")
	private TypedProperty<Byte> test;
	
	
	@Path("/typedParameterByteNameOkDefValBad")
	@GET
	public Response testGet() {
		return Response.ok("Byte typed property, name ok default value bad: " + test).build();
	}
	
	@Path("/typedParameterByteNameOkDefValBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<Byte> testGetTest() {
		return test;
	}
}