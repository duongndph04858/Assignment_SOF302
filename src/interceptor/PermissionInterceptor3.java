package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import model.entity.STAFFS;

public class PermissionInterceptor3 extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		STAFFS st = (STAFFS) session.getAttribute("tk");
		if (st.getLevel().getId() == 3 && st.getDepart().getId().equals("IT")) {
			response.sendRedirect(request.getContextPath() + "/permission.htm");
			return false;
		}
		return true;
	}

}
