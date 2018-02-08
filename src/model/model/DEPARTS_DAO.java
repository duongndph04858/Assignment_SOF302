package model.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import model.entity.DEPARTS;

@Component("depart")
public class DEPARTS_DAO {
	@Autowired
	SessionFactory factory;

	public DEPARTS_DAO() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<DEPARTS> getListDeparts() {
		Session session = factory.getCurrentSession();
		String hql = "from DEPARTS";
		Query query = session.createQuery(hql);
		List<DEPARTS> listDepart = query.list();
		return listDepart;
	}
}
