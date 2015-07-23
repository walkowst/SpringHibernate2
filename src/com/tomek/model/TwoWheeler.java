package com.tomek.model;

import javax.persistence.Entity;

@Entity
public class TwoWheeler extends Vehicle {
	
	private String steeringHandle;

	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}

	public String toString(){
		return " steeringHandle= "+steeringHandle+", name= "+this.getName() + ", Id= " + this.getId();
	}
	
}
