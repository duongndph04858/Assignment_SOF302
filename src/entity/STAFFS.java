package entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "STAFFS")
public class STAFFS {
	@Id
	@Column(name = "Username")
	private String Username;
	@Column(name = "Name")
	private String Name;
	@Column(name = "Gender")
	private Boolean Gender;
	@Column(name = "Birthday")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/DD/YYYY")
	private Date Birthday;
	@Column(name = "Photo")
	private String Photo;
	@Column(name = "Email")
	private String Email;
	@Column(name = "Phone")
	private String Phone;
	@Column(name = "Salary")
	private Long Salary;
	@Column(name = "Note")
	private String Note;
	@Column(name = "DepartId")
	private String DepartId;

	public STAFFS() {
		// TODO Auto-generated constructor stub
	}

	public STAFFS(String username, String name, Boolean gender, Date birthday, String photo, String email, String phone,
			Long salary, String note, String departId) {
		super();
		Username = username;
		Name = name;
		Gender = gender;
		Birthday = birthday;
		Photo = photo;
		Email = email;
		Phone = phone;
		Salary = salary;
		Note = note;
		DepartId = departId;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Boolean getGender() {
		return Gender;
	}

	public void setGender(Boolean gender) {
		Gender = gender;
	}

	public Date getBirthday() {
		return Birthday;
	}

	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}

	public String getPhoto() {
		return Photo;
	}

	public void setPhoto(String photo) {
		Photo = photo;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public Long getSalary() {
		return Salary;
	}

	public void setSalary(Long salary) {
		Salary = salary;
	}

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
	}

	public String getDepartId() {
		return DepartId;
	}

	public void setDepartId(String departId) {
		DepartId = departId;
	}

}
