package com.tomek.main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tomek.dao.PersonDAO;
import com.tomek.model.Person;
/**
 * Main class
 * Project created to test integration of Spring 4.1.6 and Hibernate 4.3.10
 * @project SpringHibernate
 * @Date 22/07/15
 * @version 1.0
 * @author Tomek
 * 
 */
public class SpringHibernateMain {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring4.xml");
		
		PersonDAO personDAO = context.getBean(PersonDAO.class);
		
		Person person = new Person();
		person.setName("Xiao");
		person.setCountry("China");
		
		personDAO.save(person);
		
		System.out.println("Person::"+ person);
		
		List<Person> list = personDAO.list();
		
		for(Person p : list)
			System.out.println("Person list::" + p);
		
		context.close();
	}
	
}
