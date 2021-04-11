package tn.dari.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Favoris extends Pub implements Serializable {
	
	private boolean available ;

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	} 
	
	
	
	
	

}
