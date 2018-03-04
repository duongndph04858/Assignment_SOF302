package model.model;

import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import model.entity.STAFFS;

@Component
public class STAFFS_DAO {
	@Autowired
	SessionFactory factory;

	public STAFFS_DAO() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public ArrayList<STAFFS> getListStaffs() {
		Session session = factory.getCurrentSession();
		String hql = "from STAFFS order by LevelId";
		Query query = session.createQuery(hql);
		ArrayList<STAFFS> listStaffs = (ArrayList<STAFFS>) query.list();
		return listStaffs;
	}

	@Transactional
	public STAFFS getStaff(String username) {
		Session session = factory.getCurrentSession();
		String hql = "from STAFFS where Username=:username";
		Query query = session.createQuery(hql);
		query.setParameter("username", username);
		STAFFS staff = (STAFFS) query.uniqueResult();
		return staff;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public ArrayList<STAFFS> getListStaffByDP(String departID) {
		Session session = factory.getCurrentSession();
		String hql = "from STAFFS where DepartId=:departID order by LevelId";
		Query query = session.createQuery(hql);
		query.setParameter("departID", departID);
		ArrayList<STAFFS> listStaffs = (ArrayList<STAFFS>) query.list();
		return listStaffs;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public ArrayList<STAFFS> getStaffPage(int min, int max, String departID) {
		Session session = factory.getCurrentSession();
		String hql = "from STAFFS where DepartId=:departID";
		Query query = session.createQuery(hql);
		query.setParameter("departID", departID);
		query.setFirstResult(min);
		query.setMaxResults(max);
		ArrayList<STAFFS> listStaffs = (ArrayList<STAFFS>) query.list();
		return listStaffs;
	}

	public void insertStaff(STAFFS staff) {
		Session session = factory.openSession();
		try {
			Transaction tr = session.beginTransaction();
			session.save(staff);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	} 
	public boolean updateStaff(STAFFS staff) {
		Session session = factory.openSession();
		try {
			Transaction tr = session.beginTransaction();
			session.update(staff);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}
}
