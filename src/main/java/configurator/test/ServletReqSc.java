package configurator.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// When used without running ServletWithInstance works as expected (doesnt change value after calling changeObject)
// But after calling ServletWithInstance it reloads servlet.
//		ServletWithInstance replaces value in jsonProperties and @ReqSc bean is reloaded at every request.

// curl http://localhost:8080/ConfiguratorTest/res/json/changeObject
// curl http://localhost:8080/ConfiguratorTest/testReqScope

//Injects using a CDI bean Request scoped - reloads but takes from jsonProperties (no runtime check)
@WebServlet("/testReqScope")
public class ServletReqSc extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Inject
    BeanReqScope st;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h3>Hello World from Servlet!</h3>");
		
		out.println(st.getTest());

				
		out.println("");
		
    }
    
}
