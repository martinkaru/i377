
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HomePage
 */
@WebServlet("/HomePage")
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		Object param = request.getParameter("param");
		
		response.getWriter().println("System says Hi!");
		response.getWriter().println("Your session id is " + session.getId());
		
		if (param != null) {
			session.setAttribute("param", param);	
		}
		else {
			param = session.getAttribute("param");
		}
		response.getWriter().printf("The param saved to session is: %s", param);
	}

}
