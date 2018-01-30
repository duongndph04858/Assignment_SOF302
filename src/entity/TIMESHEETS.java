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
@Table(name = "TIMESHEETS")
public class TIMESHEETS {
	@Id
	@Column(name = "Username")
	private String Username;
	@Column(name = "Date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/DD/YYYY")
	private Date Date;
	@Column(name = "Present")
	private Boolean Present;

	public TIMESHEETS() {
		// TODO Auto-generated constructor stub
	}

	public TIMESHEETS(String username, java.sql.Date date, Boolean present) {
		super();
		Username = username;
		Date = date;
		Present = present;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public Boolean getPresent() {
		return Present;
	}

	public void setPresent(Boolean present) {
		Present = present;
	}

}
