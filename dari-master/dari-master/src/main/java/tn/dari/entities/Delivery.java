package tn.dari.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Delivery implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int idDelivery ; 
	@Temporal(TemporalType.DATE)
	private Date dateDelivery ;
	private String location ; 
	private boolean areaCovered ;
	@OneToOne
	private OrderFurnitureEntity order ; 
	public int getIdDelivery() {
		return idDelivery;
	}
	public void setIdDelivery(int idDelivery) {
		this.idDelivery = idDelivery;
	}
	public Date getDateDelivery() {
		return dateDelivery;
	}
	public void setDateDelivery(Date dateDelivery) {
		this.dateDelivery = dateDelivery;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public boolean isAreaCovered() {
		return areaCovered;
	}
	public void setAreaCovered(boolean areaCovered) {
		this.areaCovered = areaCovered;
	}
	
	

}
