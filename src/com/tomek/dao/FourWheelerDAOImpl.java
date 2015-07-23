package com.tomek.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tomek.model.FourWheeler;
import com.tomek.model.Person;

public class FourWheelerDAOImpl implements FourWheelerDAO {

private SessionFactory sessionFactory;
	
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(FourWheeler fw) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(fw);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FourWheeler> list() {
		Session session = this.sessionFactory.openSession();
		List<FourWheeler> fourWheelerList = session.createQuery("from FourWheeler").list();
		session.close();
		return fourWheelerList;
	}

}
