package tn.dari.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class OrderFurnitureEntity implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOrder; 
	private float price ; 
	@Temporal(TemporalType.DATE)
	private Date dateOrder ; 
	private int nbOfOrders ;
	@OneToMany
	private List<Furniture> furnitures ; 
	@OneToOne
	private Delivery delivery ;
	
	public int getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Date getDateOrder() {
		return dateOrder;
	}
	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}
	public int getNbOfOrders() {
		return nbOfOrders;
	}
	public void setNbOfOrders(int nbOfOrders) {
		this.nbOfOrders = nbOfOrders;
	}
	public OrderFurnitureEntity(int idOrder, float price, Date dateOrder, int nbOfOrders, List<Furniture> furnitures,
			Delivery delivery) {
		super();
		this.idOrder = idOrder;
		this.price = price;
		this.dateOrder = dateOrder;
		this.nbOfOrders = nbOfOrders;
		this.furnitures = furnitures;
		this.delivery = delivery;
	} 
	
	
	

}
