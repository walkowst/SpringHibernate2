package com.tomek.dao;

import java.util.List;

import com.tomek.model.FourWheeler;
import com.tomek.model.Person;

/**
 * Data Access Object interface
 * @project SpringHibernate
 * @Date 22/07/15
 * @version 1.0
 * @author Tomek
 *
 */
public interface FourWheelerDAO {

	public void save(FourWheeler fw);
	public List<FourWheeler> list();
}
