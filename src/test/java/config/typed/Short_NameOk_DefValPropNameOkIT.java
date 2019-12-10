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

public class Short_NameOk_DefValPropNameOkIT {
	
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
	public void typed_Short_NameOk_DefValPropNameOk() {
		
		WebTarget target = client.target("http://localhost:8080/ConfiguratorTest/res/config/typedParameterShortNameOkDefValPropertyOk/test");
		
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		TypedProperty<Short> entity = response.readEntity(new GenericType<TypedProperty<Short>>(){});
		
		assertNotNull(entity);
		assertThat(entity.getPropertyName(), is("testFilePropShort"));
		
		assertNotNull(entity.getValue());
		assertThat(entity.getValue(), instanceOf(Short.class));
		assertThat(entity.getValue(), is(Short.valueOf("10")));
		
		assertNotNull(entity.getDefaultValue());
		assertThat(entity.getDefaultValue(), instanceOf(Short.class));
		assertThat(entity.getDefaultValue(), is(Short.valueOf("11")));
		
	}

}
