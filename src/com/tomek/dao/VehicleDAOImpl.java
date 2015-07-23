package com.tomek.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tomek.model.Vehicle;

/**
 * Data Access Object VehicleDAOImpl
 * @project SpringHibernate
 * @Date 22/07/15
 * @version 1.0
 * @author Tomek
 *
 */


public class VehicleDAOImpl implements VehicleDAO {
	
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Vehicle v) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(v);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehicle> list() {
		Session session = this.sessionFactory.openSession();
		List<Vehicle> vehicleList = session.createQuery("from Vehicle").list();
		session.close();
		return vehicleList;
	}


}
