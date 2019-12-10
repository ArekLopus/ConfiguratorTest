package configurator.test;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.JsonObject;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

@RequestScoped		// Injection for every request in ServletReqSc
public class BeanReqScope {
	
	@Inject
	@ConfigJson(url = "http://localhost:8080/ConfiguratorTest/res/json/object")
	TypedProperty<JsonObject> test;
	
	public TypedProperty<JsonObject> getTest() {
		return test;
	}
}
