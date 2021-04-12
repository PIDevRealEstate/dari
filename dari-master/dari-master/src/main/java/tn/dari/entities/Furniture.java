package tn.dari.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity

public class Furniture implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFurniture ; 
	private String typeFurniture ;
	
	@ManyToOne
	private OrderFurnitureEntity order ;
	@ManyToOne
	private User user ;
	
	public int getIdFurniture() {
		return idFurniture;
	}
	public void setIdFurniture(int idFurniture) {
		this.idFurniture = idFurniture;
	}
	public String getTypeFurniture() {
		return typeFurniture;
	}
	public void setTypeFurniture(String typeFurniture) {
		this.typeFurniture = typeFurniture;
	} 
	
	
	
	

}
