package config.typed_property;

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

public class Double_GetValueOrDefValOrIT {
	
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
	public void propertyTyped_getValueOrDefaultValueOr() {
		
		WebTarget target = client.target("http://localhost:8080/ConfiguratorTest/res/config/typedParameterDoubleNameBad/test");
		
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		TypedProperty<Double> entity = response.readEntity(new GenericType<TypedProperty<Double>>(){});
		Double value = entity.getValueOrDefaultValueOr(4.44);
		
		assertNotNull(entity);
		assertThat(entity.getPropertyName(), is("DoubleBadPropertyName"));
		
		assertNull(entity.getValue());
		assertNull(entity.getDefaultValue());
		
		assertThat(value, instanceOf(Double.class));
		assertThat(value, is(4.44));
		
	}

}
