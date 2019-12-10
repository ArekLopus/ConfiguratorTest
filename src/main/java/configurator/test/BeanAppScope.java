package configurator.test;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.JsonObject;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

@ApplicationScoped		// Injection for the first request only in ServletAppSc
public class BeanAppScope {
	
	@Inject
	@ConfigJson(url = "http://localhost:8080/ConfiguratorTest/res/json/object")
	TypedProperty<JsonObject> test;
	
	public TypedProperty<JsonObject> getTest() {
		return test;
	}
}
