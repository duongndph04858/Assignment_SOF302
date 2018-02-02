package controller;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import model.entity.USERS;
import util.HibernateUtil;

@Transactional
@Controller
public class test1 {
	@Autowired
	SessionFactory factory;
	@Autowired
	HibernateUtil hibernateUtil;

	public boolean checkLogin(String username, String password) {
		Session session = hibernateUtil.getSessionFactory().getCurrentSession();
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
		}
		return false;

	}

}
