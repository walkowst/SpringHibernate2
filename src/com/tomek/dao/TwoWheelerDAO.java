package com.tomek.dao;

import java.util.List;

import com.tomek.model.TwoWheeler;

/**
 * Data Access Object interface
 * @project SpringHibernate
 * @Date 22/07/15
 * @version 1.0
 * @author Tomek
 *
 */

public interface TwoWheelerDAO {
	
	public void save(TwoWheeler tw);
	public List<TwoWheeler> list();
	
}
