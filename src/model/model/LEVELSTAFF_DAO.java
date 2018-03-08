package model.model;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import model.entity.LEVELSTAFF;

@Component
public class LEVELSTAFF_DAO {
	@Autowired
	SessionFactory factory;

	public LEVELSTAFF_DAO() {
		// TODO Auto-generated constructor stub
	}

	@Transactional
	public LEVELSTAFF getLevelStaff(int level) {
		Session session = factory.getCurrentSession();
		String hql = "from LEVELSTAFF where Id=:level";
		Query query = session.createQuery(hql);
		query.setParameter("level", level);
		LEVELSTAFF levelstaff = (LEVELSTAFF) query.uniqueResult();
		return levelstaff;
	}

	@Transactional
	public ArrayList<LEVELSTAFF> getLevelStaff() {
		Session session = factory.getCurrentSession();
		String hql = "from LEVELSTAFF";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		ArrayList<LEVELSTAFF> levelstaff = (ArrayList<LEVELSTAFF>) query.list();
		return levelstaff;
	}
}
