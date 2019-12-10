package configurator.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import configurator.TypedProperty;
import configurator.annotations.ConfigJson;

// curl http://localhost:8080/ConfiguratorTest/res/json/changeObject
// curl http://localhost:8080/ConfiguratorTest/testDirect

// Injects directly - no reloads, one instance of the servlet
@WebServlet("/testDirect")
public class ServletDirect extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Inject
	@ConfigJson(url = "http://localhost:8080/ConfiguratorTest/res/json/object")
	TypedProperty<JsonObject> test;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h3>Hello World from Servlet!</h3>");
		
		out.println(test);

				
		out.println("");
		
    }
    
}
