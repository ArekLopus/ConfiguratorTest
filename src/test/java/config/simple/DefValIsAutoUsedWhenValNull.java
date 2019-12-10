package config.simple;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DefValIsAutoUsedWhenValNull {
	
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
	public void simple_IfValueNull_DefaultValueAutoUsed() {
		
		WebTarget target = client.target("http://localhost:8080/ConfiguratorTest/res/config/defaultValueUsedAutomatically/test");
		
		Response response = target.request().get();
		String entity = response.readEntity(String.class);
		
		assertNotNull(entity);
		
		assertThat(entity, instanceOf(String.class));
		assertThat(entity, equalTo("There was an error getting 'testFilePropBadName' property."));
	}

}
