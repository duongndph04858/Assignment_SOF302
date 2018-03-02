package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import model.entity.STAFFS;
import model.model.STAFFS_DAO;

@Controller
public class StaffController {

	@Autowired
	STAFFS_DAO staff;
	private ArrayList<STAFFS> lstStaff = null;

	@RequestMapping(value="/depart", params = "GD")
	public String departGD(HttpSession session,ModelMap md) {
		lstStaff = staff.getListStaffByDP("GD");
		session.setAttribute("dp", "Phòng Giám đốc");
		md.addAttribute("staffs", lstStaff);
		return "parten/phongban";
	}
	@RequestMapping(value="/depart",params = "IT")
	public String departIT(HttpSession session,ModelMap md) {
		lstStaff = staff.getListStaffByDP("IT");
		session.setAttribute("dp", "Phòng IT");
		md.addAttribute("staffs", lstStaff);
		return "parten/phongban";
	}
	@RequestMapping(value="/depart",params = "KT")
	public String departKT(HttpSession session,ModelMap md) {
		lstStaff = staff.getListStaffByDP("KT");
		session.setAttribute("dp", "Phòng Kế Toán");
		md.addAttribute("staffs", lstStaff);
		return "parten/phongban";
	}
	@RequestMapping(value="/depart",params = "NS")
	public String departNS(HttpSession session,ModelMap md) {
		session.setAttribute("dp", "Phòng Nhân Sự");
		lstStaff = staff.getListStaffByDP("NS");
		md.addAttribute("staffs", lstStaff);
		return "parten/phongban";
	}
	
	@RequestMapping(value="/staff")
	public String getListStaff(ModelMap md) {
		ArrayList<STAFFS> lstStaff = staff.getListStaffs();
		md.addAttribute("lstStaff", lstStaff);
		return "";
	}
	
	@RequestMapping(value="/staff",params="insertStaff")
	public String insert(HttpSession session) {
		return "parten/insert-staff";
	}
	
	@RequestMapping(value="/staff",params="editStaff")
	public String edit(HttpServletRequest request,ModelMap md) {
		String[] x = request.getParameterValues("username");	
		for(String s:x) {
			System.out.println(s);
		}
		return "parten/phongban";
	}
}
