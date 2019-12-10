package configurator.test.resources.typed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import configurator.TypedProperty;
import configurator.annotations.ConfigTyped;

// curl -i http://localhost:8080/ConfiguratorTest/res/config/typedParameterIntegerNameOkDefValPropertyOk

// Integer typed property, name ok default value property ok
@Path("/config")
public class Int_NameOk_DefValPropNameOk {
	
	@Inject
	@ConfigTyped(value = "testFilePropInt", defaultValueProperty = "testFilePropIntDefVal")
	private TypedProperty<Integer> test;
	
	
	@Path("/typedParameterIntegerNameOkDefValPropertyOk")
	@GET
	public Response testGet() {
		return Response.ok("Integer typed property, name ok default value property ok: " + test).build();
	}
	
	@Path("/typedParameterIntegerNameOkDefValPropertyOk/test")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TypedProperty<Integer> testGetTest() {
		return test;
	}
}