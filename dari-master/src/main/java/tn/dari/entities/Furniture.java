package tn.dari.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Furniture implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFurniture ; 
	private String TitleFurniture ;
	private String Etat_Furniture ;
	private float prixFurniture;
	private String Description ;

	@ManyToOne
	private OrderFurnitureEntity order ;
	@ManyToOne
	private User user ;
	
	@Enumerated(EnumType.STRING)
	private String Gouvernorat ; 
	
	public String getGouvernorat() {
		return Gouvernorat;
	}
	public void setGouvernorat(String gouvernorat) {
		Gouvernorat = gouvernorat;
	}
	public String getEtat_Furniture() {
		return Etat_Furniture;
	}
	public void setEtat_Furniture(String etat_Furniture) {
		Etat_Furniture = etat_Furniture;
	}
	
	public String getTitleFurniture() {
		return TitleFurniture;
	}
	public float getPrixFurniture() {
		return prixFurniture;
	}
	public void setPrixFurniture(float prixFurniture) {
		this.prixFurniture = prixFurniture;
	}
	public OrderFurnitureEntity getOrder() {
		return order;
	}
	public void setOrder(OrderFurnitureEntity order) {
		this.order = order;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setTitleFurniture(String titleFurniture) {
		TitleFurniture = titleFurniture;
	}
	
	public int getIdFurniture() {
		return idFurniture;
	}
	public void setIdFurniture(int idFurniture) {
		this.idFurniture = idFurniture;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String Description) {
		this.Description = Description;
	} 
	
	
	public Furniture() {
		super();
		// TODO Auto-generated constructor stub
	}


}
