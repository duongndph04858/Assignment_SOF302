package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.model.USER_Service;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	@Qualifier("user")
	private USER_Service user;

	@RequestMapping()
	public String login(HttpServletRequest request) {
		return "login/login";
	}

	@RequestMapping(params = "reset-password")
	public String register(ModelMap md) {
		md.addAttribute("message", "reset");
		return "login/reset-password";
	}

	@RequestMapping(params = "verify")
	public String verify(ModelMap md, @RequestParam("username") String username,
			@RequestParam("password") String password) {
		if (user.checkLogin(username, password) == true) {
			md.addAttribute("mss", "Đăng nhập thành công!");
			return "redirect:/home.htm";
		} else {
			md.addAttribute("mss", "Đăng nhập thất bại!");
			return "login/login";
		}

	}
	
}
