package model.entity;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import util.HibernateUtil;

@Entity
@Component("users")
@Table(name = "USERS")
public class USERS {
	@Id
	@Column(name = "Username")
	private String Username;
	@Column(name = "Password")
	private String Password;
	// @Autowired
	// @Qualifier("util")
	// @Transient
	// HibernateUtil util;
	@Autowired
	SessionFactory factory;

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

	public USERS getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteUser(USERS user) {
		// TODO Auto-generated method stub

	}

	public void addUser(USERS user) {
		// TODO Auto-generated method stub

	}

	public void changePassword(USERS user) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	public boolean checkLogin(String username, String password) {
		// Session session = util.getSessionFactory().openSession();
		Session session = factory.openSession();
		Transaction tr = null;
		ArrayList<USERS> lstTk = null;
		try {
			tr = session.beginTransaction();
			lstTk = (ArrayList<USERS>) session
					.createQuery("from USERS where Username= '" + username + "' and Password='" + password + "'")
					.list();
			tr.commit();
			if (lstTk.size() >= 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;

	}

}
