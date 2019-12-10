package configurator.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;
import configurator.enums.RuntimeCheckType;

// curl http://localhost:8080/ConfiguratorTest/testInstance

// Injects using Instance - full reload (runtime check)
@WebServlet("/testInstance")
public class ServletWithInstance extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Inject
	@ConfigJson(url = "http://localhost:8080/ConfiguratorTest/res/json/object", runtimeCheck = RuntimeCheckType.YES)
    private Instance<TypedProperty<JsonObject>> test;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h3>Hello World from Servlet!</h3>");
		
		out.println(test.get());
				
		out.println("");
		
    }
    
}
