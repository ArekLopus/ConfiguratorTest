package configurator.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// curl http://localhost:8080/ConfiguratorTest/res/json/changeObject
// curl http://localhost:8080/ConfiguratorTest/testAppScope

//Injects using a CDI bean App scoped - no reloads - one instance of the bean
@WebServlet("/testAppScope")
public class ServletAppSc extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Inject
    BeanAppScope st;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h3>Hello World from Servlet!</h3>");
		
		out.println(st.getTest());

				
		out.println("");
		
    }
    
}
