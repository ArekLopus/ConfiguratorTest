package config.json.props;

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

public class JO_PropKeyOk_DefUrlOkIT {
	
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
	public void jsonObject_Property_KeyOk_DefaultValueUrlOk() {
		
		WebTarget target = client.target("http://localhost:8080/ConfiguratorTest/res/config/jsonObjectPropKeyOkDefUrlNameOk/test");
		
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		TypedProperty<JsonObject> entity = response.readEntity(new GenericType<TypedProperty<JsonObject>>(){});
		
		
		assertNotNull(entity);
		assertThat(entity.getPropertyName(), is("jsonObjectProp"));
		
		assertNotNull(entity.getValue());
		assertThat(entity.getValue(), instanceOf(JsonObject.class));
		assertThat(entity.getValue().getString("keyProp1"), is("valProp1"));
		
		assertNotNull(entity.getDefaultValue());
		assertThat(entity.getDefaultValue(), instanceOf(JsonObject.class));
		assertThat(entity.getDefaultValue().getString("keyJaxRsDefVal1"), is("valJaxRsDefVal1"));
		
	}

}
