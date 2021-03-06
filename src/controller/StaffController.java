package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import model.entity.RECORDS;
import model.entity.STAFFS;
import model.model.DEPARTS_DAO;
import model.model.LEVELSTAFF_DAO;
import model.model.RECORDS_DAO;
import model.model.STAFFS_DAO;
import model.model.USERS_DAO;

@Controller
public class StaffController {
	@Autowired
	ServletContext context;

	@Autowired
	STAFFS_DAO staff;

	@Autowired
	DEPARTS_DAO depart;

	@Autowired
	LEVELSTAFF_DAO lv;

	@Autowired
	USERS_DAO us;

	@Autowired
	SessionFactory factory;
	
	@Autowired
	RECORDS_DAO rec;

	@RequestMapping(value = "depart/GD")
	public String departGD(HttpSession session, ModelMap md, HttpServletRequest request) {
		int batdau = 0;
		if (request.getParameter("start") != null) {
			batdau = Integer.parseInt(request.getParameter("start"));
		}
		ArrayList<STAFFS> lst = staff.getListStaffByDP("GD");
		int sotrang = (int) Math.round(lst.size() / 4);
		ArrayList<STAFFS> lstP = staff.getStaffPage(batdau, 4, "GD");
		md.addAttribute("lstP", lstP);
		md.addAttribute("page", sotrang);
		return "admin/nhanvien";

	}

	@RequestMapping(value = "depart/KT")
	public String departKT(HttpSession session, ModelMap md, HttpServletRequest request) {
		int batdau = 0;
		if (request.getParameter("start") != null) {
			batdau = Integer.parseInt(request.getParameter("start"));
		}
		ArrayList<STAFFS> lst = staff.getListStaffByDP("KT");
		int sotrang = (int) Math.round(lst.size() / 4);
		ArrayList<STAFFS> lstP = staff.getStaffPage(batdau, 4, "KT");
		md.addAttribute("lstP", lstP);
		md.addAttribute("page", sotrang);
		return "admin/nhanvien";

	}

	@RequestMapping(value = "depart/NS")
	public String departNS(HttpSession session, ModelMap md, HttpServletRequest request) {
		int batdau = 0;
		if (request.getParameter("start") != null) {
			batdau = Integer.parseInt(request.getParameter("start"));
		}
		ArrayList<STAFFS> lst = staff.getListStaffByDP("NS");
		int sotrang = (int) Math.round(lst.size() / 4);
		ArrayList<STAFFS> lstP = staff.getStaffPage(batdau, 4, "NS");
		md.addAttribute("lstP", lstP);
		md.addAttribute("page", sotrang);
		return "admin/nhanvien";

	}

	@RequestMapping(value = "depart/IT")
	public String departIT(HttpSession session, ModelMap md, HttpServletRequest request) {
		int batdau = 0;
		if (request.getParameter("start") != null) {
			batdau = Integer.parseInt(request.getParameter("start"));
		}
		ArrayList<STAFFS> lst = staff.getListStaffByDP("IT");
		int sotrang = (int) Math.round(lst.size() / 4);
		ArrayList<STAFFS> lstP = staff.getStaffPage(batdau, 4, "IT");
		md.addAttribute("lstP", lstP);
		md.addAttribute("page", sotrang);
		return "admin/nhanvien";

	}

	@RequestMapping(value = "/staff/allstaff")
	public String getListStaff(ModelMap md, HttpServletRequest request) {
		ArrayList<STAFFS> lstStaff = staff.getListStaffs();
		int batdau = 0;

		if (request.getParameter("start") != null) {
			batdau = Integer.parseInt(request.getParameter("start"));
		}
		int sotrang = (int) Math.round(lstStaff.size() / 4);
		ArrayList<STAFFS> lst = staff.getStaffPage(batdau, 4);
		md.addAttribute("lst", lst);
		md.addAttribute("trang", sotrang);
		return "admin/allstaff";
	}

	// thêm nhân viên
	@RequestMapping(value = "/staff", params = "insertStaff")
	public String insertStaff(@RequestParam("DP") String dP, ModelMap md) {
		md.addAttribute("dp", depart.getDepart(dP));
		md.addAttribute("stf", new STAFFS());
		return "admin/insert-staff";
	}

	@RequestMapping(value = "staff", params = "insert")
	public String insert(HttpSession session, HttpServletRequest request, ModelMap md,
			@RequestParam("photo") MultipartFile photo, @RequestParam("name") String name,
			@RequestParam("address") String address, @RequestParam("username") String username,
			@RequestParam("gender") String gender, @RequestParam("birthday") Date birthday,
			@RequestParam("level") int level, @RequestParam("depart") String depart,
			@RequestParam("email") String email, @RequestParam("phone") String phone,
			@RequestParam("salary") Long salary) {
		String notes = request.getParameter("notes");
		if (notes == null) {
			notes = "";
		}
		if (photo.isEmpty()) {
			md.addAttribute("message", "Vui lòng chọn file");
		} else {
			try {
				String path = context.getRealPath("/images/" + photo.getOriginalFilename());
				System.out.println("----------" + path);
				photo.transferTo(new File(path));
			} catch (Exception e) {
				return "admin/edit-staff";
			}
		}
		boolean gioitinh = gender.equals("Nữ") ? true : false;
		boolean kq = false;
		kq = staff.insertStaff(new STAFFS(username, name, gioitinh, address, birthday, photo.getOriginalFilename(),
				email, phone, salary, notes, this.depart.getDepart(depart), lv.getLevelStaff(level)));
		if (kq == true) {
			md.addAttribute("message", "Thêm thành công");
			return "redirect:/depart/" + depart + ".htm?start=0";
		} else {
			md.addAttribute("message", "Thêm thất bại");
			return "admin/insert-staff";
		}

	}
	// sửa nhân viên

	@RequestMapping(value = "/staff", params = "editStaff")
	public String edit(HttpServletRequest request, ModelMap md) {
		String user = request.getParameter("u");
		md.addAttribute("st", staff.getStaff(user));
		return "admin/edit-staff";
	}

	@RequestMapping(value = "/staff", params = "update")
	public String update(HttpServletRequest request, ModelMap md, @RequestParam("photo") MultipartFile photo,
			@RequestParam("name") String name, @RequestParam("username") String username,
			@RequestParam("address") String address, @RequestParam("gender") String gender,
			@RequestParam("birthday") Date birthday, @RequestParam("level") int level,
			@RequestParam("depart") String depart, @RequestParam("email") String email,
			@RequestParam("phone") String phone, @RequestParam("salary") Long salary,
			@RequestParam(value = "notes", defaultValue = "", required = false) String notes) {
		if (photo.isEmpty()) {
			md.addAttribute("message", "Vui lòng chọn file");
		} else {
			try {
				String path = context.getRealPath("/images/" + photo.getOriginalFilename());
				photo.transferTo(new File(path));
				System.out.println(path);
			} catch (Exception e) {
				return "admin/edit-staff";
			}
		}
		boolean gioitinh = gender.equals("Nữ") ? true : false;
		boolean kq = false;
		kq = staff.updateStaff(new STAFFS(username, name, gioitinh, address, birthday, photo.getOriginalFilename(),
				email, phone, salary, notes, this.depart.getDepart(depart), lv.getLevelStaff(level)));
		if (kq == true) {
			return "redirect:/depart/" + depart + ".htm?start=0";
		} else {
			return "admin/edit-staff";
		}
	}

	@RequestMapping(value = "staff", params = "delete")
	public String delete(HttpServletRequest request, Model md) {
		String[] users = request.getParameterValues("u");
		boolean kq = false;
		String dp = "";
		for (String x : users) {
			STAFFS st = staff.getStaff(x);
			dp = staff.getStaff(x).getDepart().getId();
			kq = staff.deleteStaff(st);
			us.deleteUser(us.getUser(x));
		}
		if (kq == true) {
			md.addAttribute("xoa", "Xóa thành công!");
			return "redirect:/depart/" + dp + ".htm?start=0";

		} else {
			md.addAttribute("xoa", "Xóa thành công!");
			return "redirect:/depart/" + dp + ".htm?start=0";
		}
	}

	@RequestMapping("search")
	public String searchStaff(HttpServletRequest request, ModelMap md) {
		String nameOruser = request.getParameter("search");
		String dep = request.getParameter("DP");
		ArrayList<STAFFS> list = staff.searchStaff(nameOruser, nameOruser, dep);
		if (list.size() > 0) {
			md.addAttribute("listF", list);
			return "admin/found";
		} else {
			return "admin/notfound";
		}
	}
	
	@RequestMapping(value="staff", params="appreciate")
	public String appreciate(HttpServletRequest request, ModelMap md) {
		String user = request.getParameter("u");
		md.addAttribute("app", staff.getStaff(user));
		return "admin/danhgia";
	}
	
	@RequestMapping(value="appreciate",params="KT")
	public String inserReward(HttpServletRequest request) {
		String reason = request.getParameter("reason");
		String user = request.getParameter("us");
		rec.insertRW(new RECORDS("KT", reason, new Date(), staff.getStaff(user)));
		return "redirect:/reward.htm";		
	}
	
	@RequestMapping(value="appreciate",params="KL")
	public String inserDP(HttpServletRequest request) {
		String reason = request.getParameter("reason");
		String user = request.getParameter("us");
		rec.insertRW(new RECORDS("KL", reason, new Date(), staff.getStaff(user)));
		return "redirect:/disciplines.htm";		
	}
}
