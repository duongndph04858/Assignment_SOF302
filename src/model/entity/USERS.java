package model.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "USERS")
public class USERS {
	@Id
	@Column(name = "Username")
	private String username;
	@Column(name = "Password")
	private String password;
	@Column(name="DateCreated")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dateCreated;
	public USERS() {
		// TODO Auto-generated constructor stub
	}
	public USERS(String username, String password, Date dateCreated) {
		super();
		this.username = username;
		this.password = password;
		this.dateCreated = dateCreated;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	


}
