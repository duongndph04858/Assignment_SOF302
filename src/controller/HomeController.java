package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model.model.DEPARTS_DAO;

@Controller
@RequestMapping("/home")
public class HomeController {
@Autowired
DEPARTS_DAO dp;
	
@RequestMapping()
public String home(HttpSession session) {
	return "admin/home";
}

}
