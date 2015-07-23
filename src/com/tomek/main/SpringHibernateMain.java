package com.tomek.main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tomek.dao.FourWheelerDAO;
import com.tomek.dao.PersonDAO;
import com.tomek.dao.TwoWheelerDAO;
import com.tomek.dao.VehicleDAO;
import com.tomek.model.FourWheeler;
import com.tomek.model.Person;
import com.tomek.model.TwoWheeler;
import com.tomek.model.Vehicle;
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
		TwoWheelerDAO twDAO = context.getBean(TwoWheelerDAO.class);
		FourWheelerDAO fwDAO = context.getBean(FourWheelerDAO.class);
		
		Person person = (Person) context.getBean("person");
//		person.setName("John");
//		person.setCountry("USA");
		
		TwoWheeler twoWheeler = (TwoWheeler) context.getBean("twoWheeler");
//		twoWheeler.setName("Super Bike");
//		twoWheeler.setSteeringHandle("Hummer");
		
		FourWheeler fourWheeler = (FourWheeler) context.getBean("fourWheeler");
		fourWheeler.setName("Polonez");
		fourWheeler.setSteeringWheel("Wheel");
		
		twDAO.save(twoWheeler);
		fwDAO.save(fourWheeler);
		List<Person> list = personDAO.list();
		List<TwoWheeler> twoWheelerList = twDAO.list();
		List<FourWheeler> fourWheelerList = fwDAO.list();
		
//		for(Person p : list)
//			System.out.println("Person list::" + p);
		
		for(TwoWheeler tw : twoWheelerList)
			System.out.println("Two Wheeler list::" + tw);
		
		for(FourWheeler fw : fourWheelerList)
			System.out.println("Four Wheeler list::" + fw);
		
		context.close();
	}
	
}
