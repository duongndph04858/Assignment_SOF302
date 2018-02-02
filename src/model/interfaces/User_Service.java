package model.interfaces;

import model.entity.USERS;

public interface User_Service {
	
	public USERS getUser(String username);

	public void deleteUser(USERS user);

	public void addUser(USERS user);

	public void changePassword(USERS user);

	public boolean checkLogin(String username, String password);
}
