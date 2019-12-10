package config.typed.runtime;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.HashSet;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import configurator.TypedProperty;

public class DefValStr_GlobalNo_LocalNoIT {
	
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
	// If both false, always from properties. Even if requested target changed we cant see the change in the next request.
	public void typed_String_DefVal_runtimeCheckFalse_AnnotationRuntimeCheckNo() {
		
		HashSet<String> newPaths = new HashSet<String>(Arrays.asList("/config/prop1changed.properties"));
		HashSet<String> oldPaths = client.target("http://localhost:8080/ConfiguratorTest/res/config/getOldPaths").request(MediaType.APPLICATION_JSON).get(new GenericType<HashSet<String>>(){});
		WebTarget setOldPaths = client.target("http://localhost:8080/ConfiguratorTest/res/config/setOldPaths");
		WebTarget setNewPaths = client.target("http://localhost:8080/ConfiguratorTest/res/config/setNewPaths");
		
		WebTarget setRuntimecheckToFalse = client.target("http://localhost:8080/ConfiguratorTest/res/config/changeRuntime?runtime=false");
		WebTarget runtimeCheck = client.target("http://localhost:8080/ConfiguratorTest/res/config/typedDefValGlobalRuntimeNoLocalRuntimeNo/test");
		
		setRuntimecheckToFalse.request().get();
		Response requestForFirstTimeResponse = runtimeCheck.request().get();
		setNewPaths.request().post(Entity.entity(newPaths, MediaType.APPLICATION_JSON));
		Response checkAfterChangeResponse = runtimeCheck.request().get();
		setOldPaths.request().post(Entity.entity(oldPaths, MediaType.APPLICATION_JSON));
		
		TypedProperty<String> entity = requestForFirstTimeResponse.readEntity(new GenericType<TypedProperty<String>>(){});
		//String entity = requestForFirstTimeResponse.readEntity(String.class);
		assertNotNull(entity);
		
		// first check
		assertNotNull(entity.getDefaultValue());
		assertThat(entity.getDefaultValue(), instanceOf(String.class));
		assertThat(entity.getDefaultValue(), is("This is a default value property from the file 'prop1.properties'"));
		
		// after change check
		entity = checkAfterChangeResponse.readEntity(new GenericType<TypedProperty<String>>(){});
		assertNotNull(entity.getDefaultValue());
		assertThat(entity.getDefaultValue(), instanceOf(String.class));
		assertThat(entity.getDefaultValue(), is("This is a default value property from the file 'prop1.properties'"));
		
	}

}
