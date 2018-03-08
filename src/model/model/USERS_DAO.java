package model.model;

import java.util.Date;
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

@Component("user")
public class USERS_DAO {
	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory factory;
	@Autowired
	MD5 md5;

	public USERS_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Transactional
	public USERS getUser(String username) {
		Session session = factory.getCurrentSession();
		String hql = "from USERS where Username=:username";
		Query query = session.createQuery(hql);
		query.setParameter("username", username);
		USERS user = (USERS) query.uniqueResult();
		return user;
	}

	public USERS addUser(String username) {
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		try {
			USERS user = new USERS(username, md5.getmd5("123"), new Date());
			session.save(user);
			tr.commit();
			return user;
		} catch (Exception e) {
			tr.rollback();
			return null;
		} finally {
			session.close();
		}

	}

	public void changePassword(USERS user) {
		// TODO Auto-generated method stub

	}

	@Transactional
	@SuppressWarnings("unchecked")
	public boolean checkLogin(String username, String password) {
		String p = md5.getmd5(password);
		Session session = factory.openSession();
		String hql = "from USERS where Username= :username  and Password=:password ";
		Query query = session.createQuery(hql);
		query.setParameter("username", username);
		query.setParameter("password", p);
		List<USERS> lstTk = query.list();
		if (lstTk.size() > 0) {
			return true;
		} else {
			return false;
		}

	}

	public void deleteUser(USERS user) {
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		try {
			session.delete(user);
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
	}
}
