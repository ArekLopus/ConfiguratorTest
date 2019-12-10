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

public class Prop_ENV_NameOk_DefValOkIT {
	
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
	public void simple_EnvVars_NameOk_DefValOk() {
		
		WebTarget setEnvVar = client.target("http://localhost:8080/ConfiguratorTest/res/config/setEnvVar/testEnvVar-Testing Env varaibles");
		WebTarget requestEnvVar = client.target("http://localhost:8080/ConfiguratorTest/res/config/propsEnvNameOkDefValOk/test");
		WebTarget removeEnvVar = client.target("http://localhost:8080/ConfiguratorTest/res/config/removeEnvVar/testEnvVar");
		
		setEnvVar.request().get();
		Response requestedEnvVar = requestEnvVar.request().get();
		removeEnvVar.request().get();
		
		String entity = requestedEnvVar.readEntity(String.class);
		
		assertNotNull(entity);
		
		assertThat(entity, instanceOf(String.class));
		assertThat(entity, equalTo("Testing Env varaibles"));
	}

}
