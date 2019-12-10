package configurator.test.resources;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;

@SuppressWarnings({"unchecked","rawtypes"})
public class TestHelper {

	public static JsonObject jo = Json.createObjectBuilder().add("objFieldKey1", "objFieldVal1")
			.add("objFieldKey2", "objFieldVal2").build();
	public static String jos = "{\"strFieldKey1\" : \"strFieldVal1\", \"strFieldKey2\": \"strFieldVa2\"}";

	public static JsonArray ja = Json.createArrayBuilder().add("arrFieldVal1").add("arrFieldVal2").build();
	public static String jas = "[\"arrFieldVal1\", \"arrFieldVal2\"]";

	public static JsonObject joms() {
		return Json.createObjectBuilder().add("objMethodKey1", "objMethodVal1").add("objMethodKey2", "objMethodVal2").build();
	}

	public static String jomss() {
		return "{\"strMethodKey1\" : \"strMethodVal1\", \"strMethodKey2\": \"strMethodVa2\"}";
	}

	public static JsonArray jams() {
		return Json.createArrayBuilder().add("arrMethodVal1").add("arrMethodVal2").build();
	}

	public static String jamss() {
		return "[\"arrMethodVal1\", \"arrMethodVal2\"]";
	}

	public JsonObject jom() {
		return Json.createObjectBuilder().add("objMethodKey1", "objMethodVal1").add("objMethodKey2", "objMethodVal2").build();
	}
	
	
	// Sets programmatically ENV variables
	public static void setEnv(String key, String val) throws Exception {
		Map<String, String> newenv = new HashMap<>();
		newenv.put(key, val);
		try {
			Class<?> processEnvironmentClass = Class.forName("java.lang.ProcessEnvironment");
			Field theEnvironmentField = processEnvironmentClass.getDeclaredField("theEnvironment");
			theEnvironmentField.setAccessible(true);
			Map<String, String> env = (Map<String, String>) theEnvironmentField.get(null);
			env.putAll(newenv);
			Field theCaseInsensitiveEnvironmentField = processEnvironmentClass
					.getDeclaredField("theCaseInsensitiveEnvironment");
			theCaseInsensitiveEnvironmentField.setAccessible(true);
			Map<String, String> cienv = (Map<String, String>) theCaseInsensitiveEnvironmentField.get(null);
			cienv.putAll(newenv);
		} catch (NoSuchFieldException e) {
			Class[] classes = Collections.class.getDeclaredClasses();
			Map<String, String> env = System.getenv();
			for (Class cl : classes) {
				if ("java.util.Collections$UnmodifiableMap".equals(cl.getName())) {
					Field field = cl.getDeclaredField("m");
					field.setAccessible(true);
					Object obj = field.get(env);
					Map<String, String> map = (Map<String, String>) obj;
					map.clear();
					map.putAll(newenv);
				}
			}
		}
	}

	public static void removeEnv(String key) throws Exception {

		try {
			Class<?> processEnvironmentClass = Class.forName("java.lang.ProcessEnvironment");
			Field theEnvironmentField = processEnvironmentClass.getDeclaredField("theEnvironment");
			theEnvironmentField.setAccessible(true);
			Map<String, String> env = (Map<String, String>) theEnvironmentField.get(null);
			env.remove(key);
			Field theCaseInsensitiveEnvironmentField = processEnvironmentClass
					.getDeclaredField("theCaseInsensitiveEnvironment");
			theCaseInsensitiveEnvironmentField.setAccessible(true);
			Map<String, String> cienv = (Map<String, String>) theCaseInsensitiveEnvironmentField.get(null);
			cienv.remove(key);
		} catch (NoSuchFieldException e) {
			Class[] classes = Collections.class.getDeclaredClasses();
			Map<String, String> env = System.getenv();
			for (Class cl : classes) {
				if ("java.util.Collections$UnmodifiableMap".equals(cl.getName())) {
					Field field = cl.getDeclaredField("m");
					field.setAccessible(true);
					Object obj = field.get(env);
					Map<String, String> map = (Map<String, String>) obj;
					map.clear();
					map.remove(key);
				}
			}
		}
	}

}
