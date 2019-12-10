package config.json.member;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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

public class Method_ReturnsWrongType_int_IT {
	
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
	public void jsonObject_ClassMemberMethod_ReturningWrongType_Int() {
		
		WebTarget target = client.target("http://localhost:8080/ConfiguratorTest/res/config/jsonObjectMethodOkWrongReturnTypeInt/test");
		
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		TypedProperty<JsonObject> entity = response.readEntity(new GenericType<TypedProperty<JsonObject>>(){});
		
		
		assertNotNull(entity);
		assertThat(entity.getPropertyName(), is("jom"));
		
		assertNull(entity.getValue());
		
		assertNull(entity.getDefaultValue());
	}

}
