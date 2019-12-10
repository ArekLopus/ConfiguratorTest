package configurator.test;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;


public class TestInject {
	
//	@Inject
//	ConfigJson(value = "java.vm.specification.version")
//	private TypedProperty<Double> testDouble;
//	
//	@Inject
//	@ConfigTyped(value = "java.vm.specification.version")
//	private TypedProperty<Float> testFloat;
//	
//	@Inject
//	@ConfigTyped(value = "java.vm.specification.version")
//	private TypedProperty<Integer> testInt;
//	
//	@Inject
//	@ConfigTyped(value = "json")
//	private TypedProperty<String> testString;
//	
//	@Inject
//	@ConfigTyped(value = "java.vm.specification.version")
//	private TypedProperty testNoParameter;
	
	
//	@Inject
//	@ConfigTyped(value = "jsonObject", defaultValueIsClassMember = "joMethod3")
//	private TypedProperty<JsonObject> test;
	
//	@Inject
//	@ConfigTyped(value = "jsonArray", defaultValueIsClassMember = "ja")
//	private TypedProperty<JsonArray> testDynamicArray;
	
//	@Inject
//	@ConfigJson(classMember = "joMethod")
//	private TypedProperty<JsonObject> test;
//	@Inject
//	@ConfigJson(classMember = "joMethodBadName")
//	private TypedProperty<JsonObject> test;
	
//	@Inject
//	@ConfigJson(url = "http://localhost:8080/ConfiguratorTest/res/json/object")
//	private TypedProperty<JsonObject> test;
	
	
	
	public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
		
//		System.out.println(" ---- Injected: " + test);
		
//		System.out.println(" --------------- Injected: " + testDouble);
//		System.out.println(" --------------- Injected: " + testFloat);
//		System.out.println(" --------------- Injected: " + testInt);
//		System.out.println(" --------------- Injected: " + testString);
//		System.out.println(" --------------- Injected: " + testNoParameter);
		
//		System.out.println(" ---- Injected: " + testJsonObjectProperty);
//		System.out.println(" ---- Injected: " + testJsonObjectFile);
//		System.out.println(" ---- Injected: " + testJsonArrayProperty);
//		System.out.println(" ---- Injected: " + testJsonArrayFile);
//		System.out.println(" ---- Injected: " + testDynamicArray);
		
		
//		JsonObject jsonObject = testBean6.getValue();
//		System.out.println(jsonObject.getString("key1"));
//		System.out.println(jsonObject.getString("key2"));
		
 	}
	
//	private JsonObject jo = Json.createObjectBuilder().add("elKey1", "elVal1").add("elKey2", "elVal2").build();
//	private String jos = "{\"strElKey1\" : \"strElVal1\", \"strElKey2\": \"strElVa2\"}";
//	
//	private JsonArray ja = Json.createArrayBuilder().add("elVal1").add("elVal2").build();
//	private String jas = "[\"strElVal1\", \"strElVa2\"]";
//	private int in = 1;
//	
//	public JsonObject joMethod() {
//		return Json.createObjectBuilder().add("methodKey1", "\"methodVal1").add("\"methodKey2", "\"methodVal2").build();
//	}
//	public JsonArray jaMethod() {
//		return Json.createArrayBuilder().add("methodVal1").add("methodVal2").build();
//	}
//	
//	private JsonObject joMethod2() {
//		return Json.createObjectBuilder().add("methodKey11", "\"methodVal11").add("\"methodKey22", "\"methodVal22").build();
//	}
//	
//	public JsonObject joMethod3(String abc) {
//		return Json.createObjectBuilder().add("methodKey111", "\"methodVal111").add("\"methodKey222", "\"methodVal222").build();
//	}	
	
}
