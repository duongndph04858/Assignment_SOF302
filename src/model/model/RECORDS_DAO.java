package model.model;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
		String hql = "from RECORDS where Type =:KT ";
		Query query = session.createQuery(hql);
		query.setParameter("KT", "KT");
		query.setFirstResult(0);
		query.setMaxResults(10);
		@SuppressWarnings("unchecked")
		ArrayList<RECORDS> lst = (ArrayList<RECORDS>) query.list();
		return lst;
	}

	@Transactional
	public ArrayList<RECORDS> getRecKT() {
		Session session = factory.getCurrentSession();
		String hql = "from RECORDS where Type =:KT ";
		Query query = session.createQuery(hql);
		query.setParameter("KT", "KT");
		@SuppressWarnings("unchecked")
		ArrayList<RECORDS> lst = (ArrayList<RECORDS>) query.list();
		return lst;
	}

	@Transactional
	public ArrayList<RECORDS> getRecKL() {
		Session session = factory.getCurrentSession();
		String hql = "from RECORDS where Type =:KL ";
		Query query = session.createQuery(hql);
		query.setParameter("KL", "KL");
		@SuppressWarnings("unchecked")
		ArrayList<RECORDS> lst = (ArrayList<RECORDS>) query.list();
		return lst;
	}

	@Transactional
	public ArrayList<RECORDS> getRecPageKT(int min, int max) {
		Session session = factory.getCurrentSession();
		String hql = "from RECORDS  where Type =:KT ";
		Query query = session.createQuery(hql);
		query.setParameter("KT", "KT");
		query.setFirstResult(min);
		query.setMaxResults(max);
		@SuppressWarnings("unchecked")
		ArrayList<RECORDS> lst = (ArrayList<RECORDS>) query.list();
		return lst;
	}

	@Transactional
	public ArrayList<RECORDS> getRecPageKL(int min, int max) {
		Session session = factory.getCurrentSession();
		String hql = "from RECORDS  where Type =:KL ";
		Query query = session.createQuery(hql);
		query.setParameter("KL", "KL");
		query.setFirstResult(min);
		query.setMaxResults(max);
		@SuppressWarnings("unchecked")
		ArrayList<RECORDS> lst = (ArrayList<RECORDS>) query.list();
		return lst;
	}

	public void insertRW(RECORDS rec) {
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		try {
			session.save(rec);
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
	}

	public void insertDP(RECORDS rec) {
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		try {
			session.save(rec);
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
	}

}
