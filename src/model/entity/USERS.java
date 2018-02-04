package model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "USERS")
public class USERS {
	@Id
	@Column(name = "Username")
	private String Username;
	@Column(name = "Password")
	private String Password;

	public USERS() {
		// TODO Auto-generated constructor stub
	}

	public USERS(String username, String password) {
		super();
		Username = username;
		Password = password;

	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}


}
