
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * SessionCountListener
 */
public class SessionCountListener implements HttpSessionListener {
	private static int activeSessionCount = 0;

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