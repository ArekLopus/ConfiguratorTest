package configurator.test.resources;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import configurator.ConfiguratorSettings;

// http://localhost:8080/ConfiguratorTest/res/json/object
// curl http://localhost:8080/ConfiguratorTest/res/json/changeObject
// curl http://localhost:8080/ConfiguratorTest/res/json/getAllJsonProps

@Path("/json")
@Produces(MediaType.TEXT_PLAIN)
public class _ServeJson {
	
	private static int counter = 0;
	private static JsonObject jo = Json.createObjectBuilder().add("keyJaxRs1", "valJaxRs1").add("keyJaxRs2", "valJaxRs2").build();
	private static JsonArray ja = Json.createArrayBuilder().add("valJaxRs1").add("valJaxRs2").build();
	private static JsonObject jodv = Json.createObjectBuilder().add("keyJaxRsDefVal1", "valJaxRsDefVal1").add("keyJaxRsDefVal2", "valJaxRsDefVal2").build();
	private static JsonArray jadv = Json.createArrayBuilder().add("valJaxRsDefVal1").add("valJaxRsDefVal2").build();
	
	@GET
	@Path("/object")
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject getObject() {
		return jo;
	}
	
	@GET
	@Path("/array")
	@Produces(MediaType.APPLICATION_JSON)
	public JsonArray getArray() {
		return ja;
	}
	
	
	@GET
	@Path("/objectDefVal")
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject getObjectDefVal() {
		return jodv;
	}
	
	@GET
	@Path("/arrayDefVal")
	@Produces(MediaType.APPLICATION_JSON)
	public JsonArray getArrayDefVal() {
		return jadv;
	}
	
	
	@GET
	@Path("/objectBad")
	@Produces(MediaType.TEXT_PLAIN)
	public String getObjectBad() {
		return "{\"keyJaxRs1\" : \"valJaxRs1\", \"keyJaxRs2\" : \"valJaxRs2\"";
	}
	
	@GET
	@Path("/arrayBad")
	@Produces(MediaType.TEXT_PLAIN)
	public String getArrayBad() {
		return "[\"valJaxRs1\", \"valJaxRs2\"";
	}
	
	
	
	@GET
	@Path("/objectTimeout")
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject getObjectTo() {
		try {
			Thread.sleep(1200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return Json.createObjectBuilder().add("keyJaxRs1", "valJaxRs1").add("keyJaxRs2", "valJaxRs2").build();
	}
	
	@GET
	@Path("/arrayTimeout")
	@Produces(MediaType.APPLICATION_JSON)
	public JsonArray getArrayTo() {
		try {
			Thread.sleep(1200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return Json.createArrayBuilder().add("valJaxRs1").add("valJaxRs2").build();
	}
	
	
	
	@Context
	UriInfo uriInfo;
	
	@GET
	@Path("/changeObject")
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject changeObject() {
		int changedCounter = ++counter;
		jo = Json.createObjectBuilder().add("keyJaxRs1", "changed1 -> " + changedCounter).add("keyJaxRs2", "changed2 -> " + changedCounter).build();
		return jo;
	}
	@GET
	@Path("/resetObject")
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject resetObject() {
		// Need to remove from props so after changing runtimes there is no old version in properties.
		String baseUri = uriInfo.getBaseUri().toString();
		ConfiguratorSettings.getInstance().getJsonProperties().remove(baseUri + "json/object");
		jo = Json.createObjectBuilder().add("keyJaxRs1", "valJaxRs1").add("keyJaxRs2", "valJaxRs2").build();
		return jo;
	}
	
	
	@GET
	@Path("/changeArray")
	@Produces(MediaType.APPLICATION_JSON)
	public JsonArray changeArray() {
		int changedCounter = ++counter;
		ja = Json.createArrayBuilder().add("JaxRsChanged1 -> " + changedCounter).add("JaxRsChanged2 -> " + changedCounter).build();
		return ja;
	}
	@GET
	@Path("/resetArray")
	@Produces(MediaType.APPLICATION_JSON)
	public JsonArray resetArray() {
		String baseUri = uriInfo.getBaseUri().toString();
		ConfiguratorSettings.getInstance().getJsonProperties().remove(baseUri + "json/array");
		ja = Json.createArrayBuilder().add("valJaxRs1").add("valJaxRs2").build();
		return ja;
	}
	
//	jodv = Json.createObjectBuilder().add("keyJaxRsDefVal1", "valJaxRsDefVal1").add("keyJaxRsDefVal2", "valJaxRsDefVal2").build();
	@GET
	@Path("/changeObjectDefVal")
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject changeObjectDefVal() {
		int changedCounter = ++counter;
		jodv = Json.createObjectBuilder().add("keyJaxRsDefVal1", "changed1 -> " + changedCounter).add("keyJaxRsDefVal2", "changed2 -> " + changedCounter).build();
		return jodv;
	}
	@GET
	@Path("/resetObjectDefVal")
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject resetbjectDefVal() {
		String baseUri = uriInfo.getBaseUri().toString();
		ConfiguratorSettings.getInstance().getJsonProperties().remove(baseUri + "json/objectDefVal");
		jodv = Json.createObjectBuilder().add("keyJaxRsDefVal1", "valJaxRsDefVal1").add("keyJaxRsDefVal2", "valJaxRsDefVal2").build();
		return jodv;
	}
	
//	jadv = Json.createArrayBuilder().add("valJaxRsDefVal1").add("valJaxRsDefVal2").build();
	@GET
	@Path("/changeArrayDefVal")
	@Produces(MediaType.APPLICATION_JSON)
	public JsonArray changeArrayDefVal() {
		int changedCounter = ++counter;
		jadv = Json.createArrayBuilder().add("valJaxRsDefValChanged1 -> " + changedCounter).add("valJaxRsDefValChanged2 -> " + changedCounter).build();
		return jadv;
	}
	@GET
	@Path("/resetArrayDefVal")
	@Produces(MediaType.APPLICATION_JSON)
	public JsonArray resetArrayDefVal() {
		String baseUri = uriInfo.getBaseUri().toString();
		ConfiguratorSettings.getInstance().getJsonProperties().remove(baseUri + "json/arrayDefVal");
		jadv = Json.createArrayBuilder().add("valJaxRsDefVal1").add("valJaxRsDefVal2").build();
		return jadv;
	}
	
	
	@GET
	@Path("/getAllJsonProps")
	@Produces(MediaType.TEXT_PLAIN)
	public String getAllJsonProps() {
		
		return ConfiguratorSettings.getInstance().getJsonProperties().toString();
	}
	
	
	
//	@GET
//	@Produces(MediaType.APPLICATION_OCTET_STREAM)
//	public Response getFile() {
//	  File file = ... // Initialize this to the File path you want to serve.
//	  return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
//	      .header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"" ) //optional
//	      .build();
//	}
	
	
	
}