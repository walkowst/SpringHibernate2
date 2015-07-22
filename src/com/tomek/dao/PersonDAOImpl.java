package com.tomek.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tomek.model.Person;
/**
 * Data Access Object PersonDAOImpl
 * @project SpringHibernate
 * @Date 22/07/15
 * @version 1.0
 * @author Tomek
 *
 */
public class PersonDAOImpl implements PersonDAO {

	private SessionFactory sessionFactory;
	
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Person p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(p);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> list() {
		Session session = this.sessionFactory.openSession();
		List<Person> personList = session.createQuery("from Person").list();
		session.close();
		return personList;
	}

}
