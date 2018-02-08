package model.model;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
		String hql = "from STAFFS order by Level";
		Query query = session.createQuery(hql);
		ArrayList<STAFFS> listStaffs = (ArrayList<STAFFS>) query.list();
		return listStaffs;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public ArrayList<STAFFS> getListStaffByDP(String departID) {
		Session session = factory.getCurrentSession();
		String hql = "from STAFFS where DepartId=:departID order by Level";
		Query query = session.createQuery(hql);
		query.setParameter("departID", departID);
		ArrayList<STAFFS> listStaffs = (ArrayList<STAFFS>) query.list();
		return listStaffs;
	}
}
