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

public class Prop_File_NameOkIT {
	
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
	public void simple_File_NameOk() {
		
		WebTarget requestSystemProp = client.target("http://localhost:8080/ConfiguratorTest/res/config/propsFileNameOk/test");
		
		Response requestedSystemProp = requestSystemProp.request().get();
		
		String entity = requestedSystemProp.readEntity(String.class);
		
		assertNotNull(entity);
		
		assertThat(entity, instanceOf(String.class));
		assertThat(entity, equalTo("This is a property from the file 'prop1.properties'"));
	}

}
