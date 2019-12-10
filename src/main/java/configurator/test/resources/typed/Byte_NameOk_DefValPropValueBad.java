package configurator.test.resources.typed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigTyped;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedParameterByteNameOkDefValPropertyValueBad

// Byte typed property, name ok default value property value bad
@Path("/config")
public class Byte_NameOk_DefValPropValueBad {
	
	@Inject
	@ConfigTyped(value = "testFilePropByte", defaultValueProperty = "testFilePropByteDefValBad")
	private TypedProperty<Byte> test;
	
	
	@Path("/typedParameterByteNameOkDefValPropertyValueBad")
	@GET
	public Response testGet() {
		return Response.ok("Byte typed property, name ok default value property value bad: " + test).build();
	}
	
	@Path("/typedParameterByteNameOkDefValPropertyValueBad/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<Byte> testGetTest() {
		return test;
	}
}