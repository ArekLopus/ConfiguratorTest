package config.json.misc;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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

public class EmptyConfigJsonAttrIT {
	
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
	public void jsonObject_NoConfigJsonAttributes() {
		
		WebTarget target = client.target("http://localhost:8080/ConfiguratorTest/res/config/jsonObjectEmptyValueAttribute/test");
		
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		TypedProperty<String> entity = response.readEntity(new GenericType<TypedProperty<String>>(){});
		
		assertNotNull(entity);
		assertNull(entity.getPropertyName());
		
		assertNull(entity.getValue());
		
		assertNull(entity.getDefaultValue());
		
	}

}
