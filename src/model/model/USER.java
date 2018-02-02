package model.model;

import org.springframework.stereotype.Component;
import model.entity.USERS;
import model.interfaces.User_Service;

@Component("user")
public class USER {
	private User_Service iuser;
	public USER(User_Service iuser) {
		this.iuser = iuser;
	}

	public USER() {
		super();
		// TODO Auto-generated constructor stub
	}

	public USERS getUser(String username) {
		return iuser.getUser(username);
	}

	public boolean checkLogin(String username, String password) {
		return iuser.checkLogin(username, password);
	}
}
