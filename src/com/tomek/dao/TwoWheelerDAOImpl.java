package com.tomek.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tomek.model.Person;
import com.tomek.model.TwoWheeler;

public class TwoWheelerDAOImpl implements TwoWheelerDAO {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(TwoWheeler tw) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(tw);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TwoWheeler> list() {
		Session session = this.sessionFactory.openSession();
		List<TwoWheeler> twoWheelerList = session.createQuery("from TwoWheeler").list();
		session.close();
		return twoWheelerList;
	}

}
