package model.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import model.entity.USERS;


@Transactional
@Component("user")
public class USER_Service {
	@Autowired @Qualifier("sessionFactory")
	SessionFactory factory;

	public USER_Service() {
		super();
		// TODO Auto-generated constructor stub
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
		 Session session = factory.openSession();
//		Session session = new HibernateUtil().getSessionFactory().openSession();
		List<USERS> lstTk = null;
		String hql = "from USERS where Username= :username  and Password=:password ";
		Query query = session.createQuery(hql);
		query.setParameter("username", username);
		query.setParameter("password", password);
		lstTk = query.list();
		if (lstTk.size() > 0) {
			return true;
		} else {
			return false;
		}

	}

	public static void main(String[] args) {
		USER_Service u = new USER_Service();
		System.out.println(u.checkLogin("123", "123"));
	}
}
