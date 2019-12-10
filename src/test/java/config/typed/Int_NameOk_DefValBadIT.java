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

public class Int_NameOk_DefValBadIT {
	
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
	public void typed_Integer_NameOk_DefValBad() {
		
		WebTarget target = client.target("http://localhost:8080/ConfiguratorTest/res/config/typedParameterIntegerNameOkDefValBad/test");
		
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		TypedProperty<Integer> entity = response.readEntity(new GenericType<TypedProperty<Integer>>(){});
		
		assertNotNull(entity);
		assertThat(entity.getPropertyName(), is("testFilePropInt"));
		
		assertNotNull(entity.getValue());
		assertThat(entity.getValue(), instanceOf(Integer.class));
		assertThat(entity.getValue(), is(8));
		
		assertNull(entity.getDefaultValue());
		
	}

}
