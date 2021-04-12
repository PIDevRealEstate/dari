package tn.dari.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public  class DeliveryMan implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUser ;  
	@Column(nullable = false , unique = true , length = 45)
	private String email ; 
	@Column(nullable = false ,  length = 20)
	private String password ; 
	@Column(nullable = false ,  length = 20)
	private String firstName ; 
	@Column(nullable = false ,  length = 20)
	private String lastName ;
	@Enumerated(EnumType.STRING)
	private String Gouvernorat ;  

 	private int Feed_Back_point;
	

	@OneToMany (mappedBy="DeliveryMan")
	private List<Pub> pubs ; 
	@OneToMany (mappedBy="DeliveryMan")
	private List<CreditCard> creditCards ; 
	@OneToMany (mappedBy="DeliveryMan")
	private List<Claim> claims ;
	@OneToOne
	private Subscription subscription ;
	@OneToMany (mappedBy="DeliveryMan")
	private List<Furniture> furnitures ; 
	@OneToMany (mappedBy="DeliveryMan")
	private List<OrderFurnitureEntity> OrderDelivery ; 


	public DeliveryMan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getFeed_Back_point() {
		return Feed_Back_point;
	}
	public void setFeed_Back_point(int feed_Back_point) {
		Feed_Back_point = feed_Back_point;
	}
	public List<OrderFurnitureEntity> getOrderDelivery() {
		return OrderDelivery;
	}
	public void setOrderDelivery(List<OrderFurnitureEntity> orderDelivery) {
		OrderDelivery = orderDelivery;
	}	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	 


}
