package com.tomek.dao;

import java.util.List;

import com.tomek.model.Vehicle;

/**
 * Data Access Object interface
 * @project SpringHibernate
 * @Date 22/07/15
 * @version 1.0
 * @author Tomek
 *
 */
public interface VehicleDAO {

	public void save(Vehicle v);
	public List<Vehicle> list();
	
	
}
