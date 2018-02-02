package model.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import model.entity.USERS;

@Component("user")
public class USER_Service {
	private USERS users;
	@Autowired
	public USER_Service(USERS users) {
		this.users = users;
	}

	public USER_Service() {
		super();
		// TODO Auto-generated constructor stub
	}

	public USERS getUser(String username) {
		return users.getUser(username);
	}

	public boolean checkLogin(String username, String password) {
		return users.checkLogin(username, password);
	}
}
