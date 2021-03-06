package model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "STAFFS")
public class STAFFS {
	@Id
	@Column(name = "Username")
	private String username;
	@Column(name = "Name")
	private String name;
	@Column(name = "Gender")
	private boolean gender;
	@Column(name = "Address")
	private String address;
	@Column(name = "Birthday")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private Date birthday;
	@Column(name = "Photo")
	private String photo;
	@Column(name = "Email")
	private String email;
	@Column(name = "Phone")
	private String phone;
	@Column(name = "Salary")
	private Long salary;
	@Column(name = "Notes")
	private String notes;
	@ManyToOne
	@JoinColumn(name = "DepartId")
	private DEPARTS depart;
	@ManyToOne
	@JoinColumn(name = "LevelId")
	private LEVELSTAFF level;
	public STAFFS(String username, String name, boolean gender, String address, Date birthday, String photo,
			String email, String phone, Long salary, String notes, DEPARTS depart, LEVELSTAFF level) {
		super();
		this.username = username;
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.birthday = birthday;
		this.photo = photo;
		this.email = email;
		this.phone = phone;
		this.salary = salary;
		this.notes = notes;
		this.depart = depart;
		this.level = level;
	}
	public STAFFS() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public DEPARTS getDepart() {
		return depart;
	}
	public void setDepart(DEPARTS depart) {
		this.depart = depart;
	}
	public LEVELSTAFF getLevel() {
		return level;
	}
	public void setLevel(LEVELSTAFF level) {
		this.level = level;
	}

	

}
