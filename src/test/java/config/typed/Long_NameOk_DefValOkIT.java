package config.typed;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
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

public class Long_NameOk_DefValOkIT {
	
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
	public void typed_Long_NameOk_DefValOk() {
		
		WebTarget target = client.target("http://localhost:8080/ConfiguratorTest/res/config/typedParameterLongNameOkDefValOk/test");
		
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		TypedProperty<Long> entity = response.readEntity(new GenericType<TypedProperty<Long>>(){});
		
		assertNotNull(entity);
		assertThat(entity.getPropertyName(), is("testFilePropLong"));
		
		assertNotNull(entity.getValue());
		assertThat(entity.getValue(), instanceOf(Long.class));
		assertThat(entity.getValue(), is(6L));
		
		assertNotNull(entity.getDefaultValue());
		assertThat(entity.getDefaultValue(), instanceOf(Long.class));
		assertThat(entity.getDefaultValue(), is(2L));
		
	}

}
