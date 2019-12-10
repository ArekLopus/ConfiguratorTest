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

public class Double_NameOkIT {
	
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
	public void typed_Double_NameOk() {
		
		WebTarget target = client.target("http://localhost:8080/ConfiguratorTest/res/config/typedParameterDoubleNameOk/test");
		
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		TypedProperty<Double> entity = response.readEntity(new GenericType<TypedProperty<Double>>(){});
		
		assertNotNull(entity);
		assertThat(entity.getPropertyName(), is("testFilePropDouble"));
		
		assertNotNull(entity.getValue());
		assertThat(entity.getValue(), instanceOf(Double.class));
		assertThat(entity.getValue(), is(2.67));
		
		assertNull(entity.getDefaultValue());
		
	}

}
