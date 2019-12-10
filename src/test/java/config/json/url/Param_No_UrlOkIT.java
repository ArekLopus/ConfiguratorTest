package config.json.url;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import configurator.TypedProperty;

@SuppressWarnings("rawtypes")
public class Param_No_UrlOkIT {
	
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
	public void jsonObject_Url_ParameterNo() {
		
		WebTarget target = client.target("http://localhost:8080/ConfiguratorTest/res/config/jsonObjectUrlParemeterNo/test");
		
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		
		TypedProperty entity = response.readEntity(TypedProperty.class);
		
		assertNotNull(entity);
		assertThat(entity.getPropertyName(), is("http://localhost:8080/ConfiguratorTest/res/json/object"));
		
		assertNotNull(entity.getValue());
		assertThat(entity.getValue(), instanceOf(String.class));
		assertThat(String.valueOf(entity.getValue()), startsWith("{\"keyJaxRs1"));
		
		assertNull(entity.getDefaultValue());
		
	}

}
