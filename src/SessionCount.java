import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCount extends HttpServlet implements HttpSessionListener {
	private static final long serialVersionUID = 1L;
	private static int activeSessionCount = 0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().printf("Session count: %d", getSessionCount());
	}

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		activeSessionCount++;
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		if (activeSessionCount > 0) {
			activeSessionCount--;
		}
	}

	public static int getSessionCount() {
		return activeSessionCount;
	}
}