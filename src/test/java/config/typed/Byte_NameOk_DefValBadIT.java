package config.typed;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import configurator.TypedProperty;

public class Byte_NameOk_DefValBadIT {
	
	Client client;
	
	@Before
	public void init() {
		client = ClientBuilder.newClient();
	}
	@After
	public void clean() {
		client.close();
	}

	
	@Test
	public void typed_Byte_NameOk_DefValBad() {
		
		WebTarget target = client.target("http://localhost:8080/ConfiguratorTest/res/config/typedParameterByteNameOkDefValBad/test");
		
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		TypedProperty<Byte> entity = response.readEntity(new GenericType<TypedProperty<Byte>>(){});
		
		assertNotNull(entity);
		assertThat(entity.getPropertyName(), is("testFilePropByte"));
		
		assertNotNull(entity.getValue());
		assertThat(entity.getValue(), instanceOf(Byte.class));
		assertThat(entity.getValue(), is(Byte.valueOf("12")));
		assertNull(entity.getDefaultValue());
		
	}

}
