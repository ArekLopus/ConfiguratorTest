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

public class Prop_System_NameOkIT {
	
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
	public void simple_System_NameOk() {
		
		WebTarget setSystemProp = client.target("http://localhost:8080/ConfiguratorTest/res/config/setSystemProp/testSystemProp-This is a system property");
		WebTarget requestSystemProp = client.target("http://localhost:8080/ConfiguratorTest/res/config/propsSystemNameOk/test");
		WebTarget removeSystemProp = client.target("http://localhost:8080/ConfiguratorTest/res/config/removeSystemProp/testSystemProp");
		
		setSystemProp.request().get();
		Response requestedSystemProp = requestSystemProp.request().get();
		removeSystemProp.request().get();
		
		String entity = requestedSystemProp.readEntity(String.class);
		
		assertNotNull(entity);
		
		assertThat(entity, instanceOf(String.class));
		assertThat(entity, equalTo("This is a system property"));
	}

}
