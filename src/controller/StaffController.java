package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import model.entity.STAFFS;
import model.model.STAFFS_DAO;

@Controller
public class StaffController {
	@Autowired
	ServletContext context;

	@Autowired
	STAFFS_DAO staff;

	@RequestMapping(value = "/depart")
	public String departGD(HttpSession session, ModelMap md, HttpServletRequest request) {
		int batdau = 0;

		if (request.getParameter("start") != null) {
			batdau = Integer.parseInt((String) request.getParameter("start"));
		}
		ArrayList<STAFFS> lst = staff.getListStaffByDP(request.getParameter("DP"));
		int sotrang = (int) Math.round(lst.size() / 4);
		ArrayList<STAFFS> lstP = staff.getStaffPage(batdau, 4, request.getParameter("DP"));
		md.addAttribute("lstP", lstP);
		md.addAttribute("page", sotrang);
		switch (request.getParameter("DP")) {
		case "GD":
			session.setAttribute("dp", "Phòng Giám đốc");
			session.setAttribute("phong", "GD");
			break;
		case "IT":
			session.setAttribute("dp", "Phòng IT");
			session.setAttribute("phong", "IT");
			break;
		case "KT":
			session.setAttribute("dp", "Phòng Kế Toán");
			session.setAttribute("phong", "KT");
			break;
		case "NS":
			session.setAttribute("dp", "Phòng Nhân Sự");
			session.setAttribute("phong", "NS");
			break;

		default:
			break;
		}
		return "admin/phongban";

	}

	@RequestMapping(value = "/staff")
	public String getListStaff(ModelMap md) {
		ArrayList<STAFFS> lstStaff = staff.getListStaffs();
		md.addAttribute("lstStaff", lstStaff);
		return "admin/staff";
	}

	// thêm nhân viên
	@RequestMapping(value = "/staff", params = "insertStaff")
	public String insertStaff(HttpSession session) {
		return "admin/insert-staff";
	}

	@RequestMapping(value = "/staff", params = "insert")
	public String insert(HttpServletRequest request, ModelMap md, @RequestParam("image_uploads") MultipartFile photo,
			@RequestParam("username") String fullname, @RequestParam("username") String username,
			@RequestParam("gender") String gender, @RequestParam("dob") Date birthday,
			@RequestParam("level") int level, @RequestParam("depart") String depart,
			@RequestParam("email") String email, @RequestParam("phone") String phone,
			@RequestParam("salary") Long salary, @RequestParam("notes") String notes) {
		if (photo.isEmpty()) {
			md.addAttribute("message", "Vui lòng chọn file");
		} else {
			try {
				String path = context.getRealPath("/images/" + photo.getOriginalFilename());
				photo.transferTo(new File(path));
				System.out.println(path);
			} catch (Exception e) {
				System.out.println("lỗi-----------------------------------");
			}
		}
		boolean gioitinh = gender.equals("Nữ") ? true : false;
		boolean kq = false;
		kq = staff.insertStaff(new STAFFS(fullname, username, gioitinh, birthday, photo.getOriginalFilename(), email,
				phone, salary, notes, depart, level));
		if (kq == true) {
			System.out.println("======================================");
			System.out.println("update thanh cong");
			return "redirect:/depart.htm?DP=" + depart + "&start=0";
		} else {
			return "admin/edit-staff";
		}
	}
	// sửa nhân viên

	@RequestMapping(value = "/staff", params = "editStaff")
	public String edit(HttpServletRequest request, ModelMap md) {
		String user = request.getParameter("username");
		md.addAttribute("user", staff.getStaff(user));
		// String[] user = request.getParameterValues("username");
		// for (String x : user) {
		// md.addAttribute("user", staff.getStaff(x));
		// }
		return "admin/edit-staff";
	}

	@RequestMapping(value = "staff", params = "update")
	public String update(HttpServletRequest request, ModelMap md, @RequestParam("photo") MultipartFile photo,
			@RequestParam("name") String name, @RequestParam("username") String username,
			@RequestParam("gender") String gender, @RequestParam("birthday") Date birthday,
			@RequestParam("level") int level, @RequestParam("depart") String depart,
			@RequestParam("email") String email, @RequestParam("phone") String phone,
			@RequestParam("salary") Long salary, @RequestParam("notes") String notes) {
		if (photo.isEmpty()) {
			md.addAttribute("message", "Vui lòng chọn file");
		} else {
			try {
				String path = context.getRealPath("/images/" + photo.getOriginalFilename());
				photo.transferTo(new File(path));
				System.out.println(path);
			} catch (Exception e) {
				System.out.println("lỗi-----------------------------------" + e);
			}
		}
		boolean gioitinh = gender.equals("Nữ") ? true : false;
		boolean kq = false;
		kq = staff.updateStaff(new STAFFS(username, name, gioitinh, birthday, photo.getOriginalFilename(), email, phone,
				salary, notes, depart, level));
		if (kq == true) {
			System.out.println("======================================");
			System.out.println("update thanh cong");
			return "redirect:/depart.htm?DP=" + depart + "&start=0";
		} else {
			return "admin/edit-staff";
		}
	}

	@RequestMapping(value = "/staff", params = "start")
	public String getListStaffbyPage(HttpServletRequest request, ModelMap md, HttpSession session) {

		return "admin/phongban";
	}

}
