package controller;

import java.util.Random;

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
	@Autowired @Qualifier("user")
	private USER_Service user;
	@RequestMapping()
	public String login(HttpServletRequest request) {
		Random rd = new Random();
		request.setAttribute("stt", rd.nextInt(10));
		return "login/login";
	}

	@RequestMapping(params = "reset-password")
	public String register(ModelMap md) {
		md.addAttribute("message", "reset");
		return "login/reset-password";
	}

	@RequestMapping(params = "verify")
	public String verify(ModelMap md, @RequestParam("username") String username, @RequestParam("password") String password) {
		if (user.checkLogin(username, password)==true) {
			md.addAttribute("mss", "Đăng nhập thành công");
			return "redirect:/home";
		} else {
			if (username.isEmpty()) {
				md.addAttribute("user-err", "Tên đăng nhập không được bỏ trống!");
			}
			if (password.isEmpty()) {
				md.addAttribute("password-err", "Mật khẩu không được bỏ trống!");
			}
			return "login/login";
		}

	}
}
