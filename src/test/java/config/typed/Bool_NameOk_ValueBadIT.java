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

public class Bool_NameOk_ValueBadIT {
	
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
	// For a boolean bad value is turned into false
	public void typed_Boolean_NameOk_ValueBad() {
		
		WebTarget target = client.target("http://localhost:8080/ConfiguratorTest/res/config/typedParameterBooleanNameOkValueBad/test");
		
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		TypedProperty<Boolean> entity = response.readEntity(new GenericType<TypedProperty<Boolean>>(){});
		
		assertNotNull(entity);
		assertThat(entity.getPropertyName(), is("testFilePropBooleanBad"));
		
		assertNotNull(entity.getValue());
		assertThat(entity.getValue(), instanceOf(Boolean.class));
		assertThat(entity.getValue(), is(false));
		
		assertNull(entity.getDefaultValue());
		
	}

}
