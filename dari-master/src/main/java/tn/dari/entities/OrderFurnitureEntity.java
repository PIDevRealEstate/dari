package tn.dari.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@Enumerated(EnumType.STRING)
	private String Gouvernorat ;  
	
	
	@OneToMany (mappedBy="OrderFurnitureEntity")
	private List<Furniture> furnitures ; 	
	@ManyToOne
	private DeliveryMan deliveryMan ;
	
	@ManyToOne 
	private User user;
	
	public String getGouvernorat() {
		return Gouvernorat;
	}
	public void setGouvernorat(String gouvernorat) {
		Gouvernorat = gouvernorat;
	}
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
	
	public List<Furniture> getFurnitures() {
		return furnitures;
	}
	public void setFurnitures(List<Furniture> furnitures) {
		this.furnitures = furnitures;
	}

	public OrderFurnitureEntity(int idOrder, float price, Date dateOrder, int nbOfOrders, List<Furniture> furnitures,
			Delivery delivery) {
		super();
		this.idOrder = idOrder;
		this.price = price;
		this.dateOrder = dateOrder;
		this.nbOfOrders = nbOfOrders;
		this.furnitures = furnitures;
		this.deliveryMan = deliveryMan;
	}
	public DeliveryMan getDeliveryMan() {
		return deliveryMan;
	}
	public void setDeliveryMan(DeliveryMan deliveryMan) {
		this.deliveryMan = deliveryMan;
	} 
	
	
	

}
