package configurator.test;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.json.JsonObject;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

@ApplicationScoped		// Injection for every request
public class BeanAppScopeInst {
	
	@Inject
	@ConfigJson(url = "http://localhost:8080/ConfiguratorTest/res/json/object")
	private Instance<TypedProperty<JsonObject>> test;
	
	public TypedProperty<JsonObject> getTest() {
		return test.get();
	}
}
