package tn.dari.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class OrderFurnitureEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String reference;
	@OneToOne
    private Delivery delivery;
	@ManyToOne
    private User user;
	private boolean paymentStat;
    private String deliveryStat;
    @ManyToMany
    private Map<Integer, Furniture> furnitures;
    private float totalPrice;
    boolean admin;
    
    
    public OrderFurnitureEntity(int id, String reference, Delivery delivery, User user, String deliveryStat,Map<Integer, Furniture> furnitures, boolean paymentStat,
			float totalPrice) {
		super();
		this.id = id;
		this.reference = reference;
		this.delivery = delivery;
		this.user = user;
		this.deliveryStat = deliveryStat;
		this.furnitures = furnitures;
		this.paymentStat = paymentStat;
		this.totalPrice = totalPrice;
	}

	public OrderFurnitureEntity() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isPaymentStat() {
		return paymentStat;
	}

	public void setPaymentStat(boolean paymentStat) {
		this.paymentStat = paymentStat;
	}

	public String getDeliveryStat() {
		return deliveryStat;
	}

	public void setDeliveryStat(String deliveryStat) {
		this.deliveryStat = deliveryStat;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public boolean isAdmin() {
		return admin;
	}


	public void setAdminStatus(boolean admin) {
		this.admin = admin;
	}

	public Map<Integer, Furniture> getFurnitures() {
		return furnitures;
	}

	public void setFurnitures(Map<Integer, Furniture> furnitures) {
		this.furnitures = furnitures;
	}
	
	
	
	
	
	
	

}
