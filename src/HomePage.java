
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HomePage
 */
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		Object param = request.getParameter("param");

		
		response.getWriter().println("System says Hi!");
		response.getWriter().printf("Your session id is %s", session.getId());
		response.getWriter().println("");
		
		if (param != null) {
			session.setAttribute("param", param);	
		}
		else {
			param = session.getAttribute("param");
		}
		response.getWriter().printf("The param saved to session is: %s", param);
	}

}
