package config.json.default_value;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.startsWith;
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

public class Param_String_DefVal_FldOkIT {
	
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
	public void jsonObject_DefaultValueClassMemberField_NameOk_ParameterString() {
		
		WebTarget target = client.target("http://localhost:8080/ConfiguratorTest/res/config/StringFieldNameOk/test");
		
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		TypedProperty<String> entity = response.readEntity(new GenericType<TypedProperty<String>>(){});
		
		
		assertNotNull(entity);
		
		assertNotNull(entity.getDefaultValue());
		assertThat(entity.getDefaultValue(), instanceOf(String.class));
		assertThat(entity.getDefaultValue(), startsWith("{\"error"));
		
	}

}
