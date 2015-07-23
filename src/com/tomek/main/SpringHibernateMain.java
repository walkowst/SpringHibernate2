package com.tomek.main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tomek.dao.PersonDAO;
import com.tomek.dao.VehicleDAO;
import com.tomek.model.Person;
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
		
		Person person = new Person();
		person.setName("John");
		person.setCountry("USA");
		
//		personDAO.save(person);
		
		System.out.println("Person::"+ person);
		
		List<Person> list = personDAO.list();
		
		for(Person p : list)
			System.out.println("Person list::" + p);
		
		VehicleDAO vehicleDAO = context.getBean(VehicleDAO.class);
		
		Vehicle vehicle = new Vehicle();
		vehicle.setType("Car");
		vehicle.setModel("Peugeot");
		
		vehicleDAO.save(vehicle);

		System.out.println("Vehicle::"+ vehicle);
		
		List<Vehicle> vehicleList = vehicleDAO.list();
		for(Vehicle v : vehicleList)
			System.out.println("Vehicle list::"+v);
		
		
		context.close();
	}
	
}
