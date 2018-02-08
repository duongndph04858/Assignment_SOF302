package model.model;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
}
