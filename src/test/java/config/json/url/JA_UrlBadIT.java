package config.json.url;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import javax.json.JsonArray;
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

public class JA_UrlBadIT {
	
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
	public void jsonArray_UrlBad() {
		
		WebTarget target = client.target("http://localhost:8080/ConfiguratorTest/res/config/jsonArrayUrlBad/test");
		
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		TypedProperty<JsonArray> entity = response.readEntity(new GenericType<TypedProperty<JsonArray>>(){});
		
		
		assertNotNull(entity);
		assertThat(entity.getPropertyName(), is("http://localhost:8080/ConfiguratorTest/res/json/BadUrl"));
		
		assertNull(entity.getValue());
		
		assertNull(entity.getDefaultValue());
	}

}
