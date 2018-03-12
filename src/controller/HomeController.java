package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import model.entity.RECORDS;
import model.model.DEPARTS_DAO;
import model.model.RECORDS_DAO;

@Controller

public class HomeController {
	@Autowired
	DEPARTS_DAO dp;

	@Autowired
	RECORDS_DAO rec;

	@RequestMapping("/home")
	public String home(ModelMap md, HttpServletRequest request) {
		int batdau = 0;
		if (request.getParameter("start") != null) {
			batdau = Integer.parseInt(request.getParameter("start"));
		}
		ArrayList<RECORDS> lst = rec.getTopStaff();
		int sotrang = (int) Math.round(lst.size() / 3);
		ArrayList<RECORDS> lstP = rec.getRecPageKT(batdau, 3);
		md.addAttribute("topstaff", lstP);
		md.addAttribute("page", sotrang);
		return "admin/home";
	}

	@RequestMapping("/reward")
	public String khenthuong(ModelMap md, HttpServletRequest request) {
		int batdau = 0;
		if (request.getParameter("start") != null) {
			batdau = Integer.parseInt(request.getParameter("start"));
		}
		ArrayList<RECORDS> lst = rec.getRecKT();
		int sotrang = (int) Math.round(lst.size() / 3);
		ArrayList<RECORDS> lstP = rec.getRecPageKT(batdau, 3);
		md.addAttribute("kt", lstP);
		md.addAttribute("page", sotrang);
		return "admin/khenthuong";
	}

	@RequestMapping("/disciplines")
	public String kyluat(ModelMap md, HttpServletRequest request) {
		int batdau = 0;
		if (request.getParameter("start") != null) {
			batdau = Integer.parseInt(request.getParameter("start"));
		}
		ArrayList<RECORDS> lst = rec.getRecKL();
		int sotrang = (int) Math.round(lst.size() / 3);
		ArrayList<RECORDS> lstP = rec.getRecPageKL(batdau, 3);
		md.addAttribute("kl", lstP);
		md.addAttribute("page", sotrang);
		return "admin/kyluat";
	}

	@RequestMapping("/thongtin")
	public String thongtin() {
		return "admin/thongtinnv";
	}

	@RequestMapping("/permission")
	public String permission() {
		return "admin/permission";
	}
}
