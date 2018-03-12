package model.entity;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "RECORDS")
public class RECORDS {
	@Id
	@Column(name = "Id")
	@GeneratedValue
	private int Id;
	@Column(name = "Type")
	private String Type;
	@Column(name = "Reason")
	private String Reason;
	@Column(name = "Date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/DD/YYYY")
	private Date Date;
	@ManyToOne
	@JoinColumn(name = "StaffUsername")
	private STAFFS staff;
	
	public RECORDS() {
		// TODO Auto-generated constructor stub
	}

	public RECORDS(String type, String reason, java.util.Date date, STAFFS staff) {
		super();
		Type = type;
		Reason = reason;
		Date = date;
		this.staff= staff;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getReason() {
		return Reason;
	}

	public void setReason(String reason) {
		Reason = reason;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public STAFFS getStaff() {
		return this.staff;
	}

	public void setStaff(STAFFS staff) {
		this.staff = staff;
	}

	
	
	
	
}
