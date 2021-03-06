package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import model.model.DEPARTS_DAO;

public class LoggerInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	DEPARTS_DAO dp;
@Override
public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
		ModelAndView modelAndView) throws Exception {
	modelAndView.getModelMap().addAttribute("departs", dp.getListDeparts());	
}
}
