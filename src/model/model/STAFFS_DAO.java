package model.model;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import model.entity.STAFFS;
import model.entity.USERS;

@Component
public class STAFFS_DAO {
	@Autowired
	SessionFactory factory;

	@Autowired
	MD5 md5;

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

	public boolean insertStaff(STAFFS staff) {
		Session session = factory.openSession();
		try {
			Transaction tr = session.beginTransaction();
			session.save(new USERS(staff.getUsername(), md5.getmd5("123"), new Date()));
			session.save(staff);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
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

	public boolean deleteStaff(STAFFS staff) {
		Session session = factory.openSession();
		try {
			Transaction tr = session.beginTransaction();
			session.delete(staff);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	@Transactional
	public 	ArrayList<STAFFS> searchStaff(String username, String name,String depart) {
		Session session = factory.getCurrentSession();
		String hql = "from STAFFS where DepartId='"+depart+"' and  (Username like '%" + username + "%' or Name like '%" + name + "%')";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		ArrayList<STAFFS> lst = (ArrayList<STAFFS>) query.list();
		return lst;
	}
}
