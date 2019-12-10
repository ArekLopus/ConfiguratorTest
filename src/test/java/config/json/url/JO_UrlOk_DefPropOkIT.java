package config.json.url;

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

public class JO_UrlOk_DefPropOkIT {
	
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
	public void jsonObject_UrlOk_DefaultValuePropertyOk() {
		
		WebTarget target = client.target("http://localhost:8080/ConfiguratorTest/res/config/jsonObjectUrlOkDefValPropNameOk/test");
		
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		TypedProperty<JsonObject> entity = response.readEntity(new GenericType<TypedProperty<JsonObject>>(){});
		
		
		assertNotNull(entity);
		assertThat(entity.getPropertyName(), is("http://localhost:8080/ConfiguratorTest/res/json/object"));
		
		assertNotNull(entity.getValue());
		assertThat(entity.getValue(), instanceOf(JsonObject.class));
		assertThat(entity.getValue().getString("keyJaxRs1"), is("valJaxRs1"));
		
		assertNotNull(entity.getDefaultValue());
		assertThat(entity.getDefaultValue(), instanceOf(JsonObject.class));
		assertThat(entity.getDefaultValue().getString("propDefValKey1"), is("propDefValVal1"));
		
	}

}
