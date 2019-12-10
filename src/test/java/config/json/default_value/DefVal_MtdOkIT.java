package config.json.default_value;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import javax.json.JsonObject;
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

public class DefVal_MtdOkIT {
	
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
	public void jsonObject_DefaultValueClassMemberMethod_NameOk() {
		
		WebTarget target = client.target("http://localhost:8080/ConfiguratorTest/res/config/DefValMethodNameOk/test");
		
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		TypedProperty<JsonObject> entity = response.readEntity(new GenericType<TypedProperty<JsonObject>>(){});
		
		assertNotNull(entity);
		
		assertNotNull(entity.getDefaultValue());
		assertThat(entity.getDefaultValue(), instanceOf(JsonObject.class));
		assertThat(entity.getDefaultValue().getString("error"), is("Method - There was an error loading value."));
		
	}

}
