package model.model;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LEVELSTAFF_DAO {
	@Autowired
	SessionFactory factory;
	public LEVELSTAFF_DAO() {
		// TODO Auto-generated constructor stub
	}
	@Transactional
	public String getLevelStaff(int level) {
		Session session = factory.getCurrentSession();
		String hql="from LEVELSTAFF where Id=:level";
		Query query = session.createQuery(hql);
		query.setParameter("level", level);
		String levelstaff =(String)  query.uniqueResult();
		return levelstaff;
	}
}
