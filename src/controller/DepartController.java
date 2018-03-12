package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import model.entity.DEPARTS;
import model.model.DEPARTS_DAO;
import model.model.STAFFS_DAO;

@Controller
public class DepartController {
	@Autowired
	DEPARTS_DAO dp;

	@Autowired
	STAFFS_DAO staff;

	@RequestMapping("mndepart")
	public String depart(ModelMap md) {
		md.addAttribute("depart", dp.getListDeparts());
		md.addAttribute("GD", staff.getListStaffByDP("GD").size());
		md.addAttribute("NS", staff.getListStaffByDP("NS").size());
		md.addAttribute("KT", staff.getListStaffByDP("KT").size());
		md.addAttribute("IT", staff.getListStaffByDP("IT").size());
		md.addAttribute("leaderGD", staff.getLeader("GD").get(0));
		md.addAttribute("leaderKT", staff.getLeader("KT").get(0));
		md.addAttribute("leaderNS", staff.getLeader("NS").get(0));
		md.addAttribute("leaderIT", staff.getLeader("IT").get(0));

		return "admin/phongban";
	}

	@RequestMapping(value = "mndepart.htm", params = "insertDepart")
	public String insertDepart() {
		return "";
	}

	@RequestMapping(value = "mndepart.htm", params = "delete")
	public String deleteDepart(HttpServletRequest request, ModelMap md) {
		String[] depart = request.getParameterValues("depart");
		boolean kq = false;
		for (String x : depart) {
			DEPARTS dp = this.dp.getDepart(x);
			kq = this.dp.deleteDepart(dp);
		}
		if (kq == true) {
			md.addAttribute("xoa", "Xóa thành công!");
			return "redirect:/home.htm";

		} else {
			md.addAttribute("xoa", "Xóa thành công!");
			return "redirect:/home.htm";
		}
	}
}
