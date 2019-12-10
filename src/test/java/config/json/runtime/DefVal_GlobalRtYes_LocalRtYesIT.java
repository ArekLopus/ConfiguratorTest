package config.json.runtime;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
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

public class DefVal_GlobalRtYes_LocalRtYesIT {
	
	Client client;
	boolean runtime = false;
	
	@Before
	public void init() {
		client = ClientBuilder.newClient();
		WebTarget getRuntime = client.target("http://localhost:8080/ConfiguratorTest/res/config/getRuntime");
		Response resp = getRuntime.request(MediaType.TEXT_PLAIN).get();
		runtime = resp.readEntity(Boolean.class);
	}
	@After
	public void clean() {
		WebTarget getRuntime = client.target("http://localhost:8080/ConfiguratorTest/res/config/changeRuntime/" + runtime);
		getRuntime.request(MediaType.TEXT_PLAIN).get();
		client.close();
	}
	
	
	@Test
	// If both true, always reload. If requested target changed we can see the change in the next request. 
	public void runtimeCheckeTrue_AnnotationRuntimeCheckYes() {
		
		WebTarget setRuntimecheckToTrue = client.target("http://localhost:8080/ConfiguratorTest/res/config/changeRuntime?runtime=true");
		WebTarget runtimeCheck = client.target("http://localhost:8080/ConfiguratorTest/res/config/DefValUrlGlobalRuntimeYesLocalRuntimeYes/test");
		WebTarget changeRequestedObject = client.target("http://localhost:8080/ConfiguratorTest/res/json/changeObjectDefVal");
		WebTarget resetBackRequestedObject = client.target("http://localhost:8080/ConfiguratorTest/res/json/resetObjectDefVal");
		
		setRuntimecheckToTrue.request().get();
		Response requestForFirstTimeResponse = runtimeCheck.request(MediaType.APPLICATION_JSON).get();
		changeRequestedObject.request(MediaType.APPLICATION_JSON).get();
		Response checkAfterChangeResponse = runtimeCheck.request(MediaType.APPLICATION_JSON).get();
		resetBackRequestedObject.request(MediaType.APPLICATION_JSON).get();
		
		TypedProperty<JsonObject> entity = requestForFirstTimeResponse.readEntity(new GenericType<TypedProperty<JsonObject>>(){});
		
		
		assertNotNull(entity);

		// first check
		assertNotNull(entity.getDefaultValue());
		assertThat(entity.getDefaultValue(), instanceOf(JsonObject.class));
		assertThat(entity.getDefaultValue().getString("keyJaxRsDefVal1"), is("valJaxRsDefVal1"));
		
		// after change check
		entity = checkAfterChangeResponse.readEntity(new GenericType<TypedProperty<JsonObject>>(){});
		assertNotNull(entity.getDefaultValue());
		assertThat(entity.getDefaultValue(), instanceOf(JsonObject.class));
		assertThat(entity.getDefaultValue().getString("keyJaxRsDefVal1"), not("valJaxRsDefVal1"));
		
	}

}
