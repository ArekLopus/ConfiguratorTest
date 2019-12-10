package config.json.cdi;

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

public class JO_CdiBean_AppScIT {
	
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
	public void runtimeCheckTrue_AnnotationRuntimeCheckYes() {
		
		WebTarget runtimeCheck = client.target("http://localhost:8080/ConfiguratorTest/res/config/jsonObjectAppScopedCdi/test");
		WebTarget changeRequestedObject = client.target("http://localhost:8080/ConfiguratorTest/res/json/changeObject");
		WebTarget resetBackRequestedObject = client.target("http://localhost:8080/ConfiguratorTest/res/json/resetObject");
		
		Response requestForFirstTimeResponse = runtimeCheck.request(MediaType.APPLICATION_JSON).get();
		changeRequestedObject.request(MediaType.APPLICATION_JSON).get();
		Response checkAfterChangeResponse = runtimeCheck.request(MediaType.APPLICATION_JSON).get();
		resetBackRequestedObject.request(MediaType.APPLICATION_JSON).get();
		
		TypedProperty<JsonObject> entity = requestForFirstTimeResponse.readEntity(new GenericType<TypedProperty<JsonObject>>(){});
		
		
		assertNotNull(entity);
		
		// first check
		assertNotNull(entity.getValue());
		assertThat(entity.getValue(), instanceOf(JsonObject.class));
		assertThat(entity.getPropertyName(), is("http://localhost:8080/ConfiguratorTest/res/json/object"));
		assertThat(entity.getValue().getString("keyJaxRs1"), is("valJaxRs1"));
		
		// after change check
		entity = checkAfterChangeResponse.readEntity(new GenericType<TypedProperty<JsonObject>>(){});
		assertNotNull(entity.getValue());
		assertThat(entity.getValue(), instanceOf(JsonObject.class));
		assertThat(entity.getPropertyName(), is("http://localhost:8080/ConfiguratorTest/res/json/object"));
		assertThat(entity.getValue().getString("keyJaxRs1"), is("valJaxRs1"));
		
	}

}
