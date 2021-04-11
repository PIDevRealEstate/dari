package tn.dari.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class PaymentCard {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@OneToOne(cascade=CascadeType.ALL)
	private Furniture furniture;
	@ManyToOne
	private User user;
	private float totalCost;

	public PaymentCard(int id, Furniture furniture, User user, float totalCost) {
		super();
		this.id= id;
		this.furniture= furniture;
		this.user= user;
		this.totalCost= totalCost;
		
	}
	
	public PaymentCard() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Furniture getFurniture() {
		return furniture;
	}

	public void setFurniture(Furniture furniture) {
		this.furniture = furniture;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}
	
	
}
