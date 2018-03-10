package model.model;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import model.entity.RECORDS;

@Component
public class RECORDS_DAO {
	@Autowired
	SessionFactory factory;

	@Transactional
	public ArrayList<RECORDS> getTopStaff() {
		Session session = factory.getCurrentSession();
		String hql = "from RECORDS";
		Query query = session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(10);
		@SuppressWarnings("unchecked")
		ArrayList<RECORDS> lst = (ArrayList<RECORDS>) query.list();
		return lst;
	}

	@Transactional
	public ArrayList<RECORDS> getRecPage(int min, int max) {
		Session session = factory.getCurrentSession();
		String hql = "from RECORDS";
		Query query = session.createQuery(hql);
		query.setFirstResult(min);
		query.setMaxResults(max);
		@SuppressWarnings("unchecked")
		ArrayList<RECORDS> lst = (ArrayList<RECORDS>) query.list();
		return lst;
	}

}
