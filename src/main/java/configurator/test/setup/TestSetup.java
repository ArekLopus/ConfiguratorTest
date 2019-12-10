package configurator.test.setup;

import configurator.annotations.ConfiguratorSetup;


@ConfiguratorSetup(value = {"/config/prop1.properties", "/config/prop2.properties"},
	runtimeCheck = false, allowDeploymentWithExceptions = true
)
//@ConfiguratorSetup(value = {"/config/prop1.properties", "/config/prop2.properties", "verbose"},
//	runtimeCheck = false, allowDeploymentWithExceptions = true
//	jsonPropertyFilePaths = {"/config/jsonObject.properties", "/config/jsonArray.properties", "badJsonName.properties", ""},
//	jsonFiles = {"/config/configObject.json", "/config/configObjectBad.json", "badJsonName.json", ""}
//	jsonUrls = {"http://localhost:8080/ConfiguratorHelper/res/json/object", "http://localhost:8080/ConfiguratorHelper/res/json/objectBad"
//			,"http://localhost:8080/ConfiguratorHelper/res/json/UrlBad"}
//	jsonMembers = {"jo", "jom", "jos", "ja", "jam","bad"}
//)
//@ConfiguratorSetup(value = {"/config/prop1.properties", "/config/prop2.properties"}, allowDeploymentWithExceptions = true, runtimeCheck = false)
//@ConfiguratorSetup(value = {"/config/prop1.properties", "/config/prop2.properties"}, allowDeploymentWithExceptions = true)
//@ConfiguratorSetup(value = {"/config/prop1.properties", "/config/prop2.properties"}, runtimeCheck = true)
//@ConfiguratorSetup({"/config/prop1.properties", "/config/prop2.properties"})
//@ConfiguratorSetup(value = {"/config/prop1.properties", "/config/prop2.properties"}, runtimeCheck = true)
//@ConfiguratorSetup(value = "/config/prop1.properties", runtimeCheck = true)
//@ConfiguratorSetup("/config/prop1.properties")
//@ConfiguratorSetup

public class TestSetup {}
