package tn.dari.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;



@Entity
public class Furniture implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	
	/*@ManyToOne
	private OrderFurnitureEntity order;*/
	@ManyToOne
	private User user;
	private String name;
	private String description;
	private String type;
	@CreationTimestamp
	private Date postDate;
	private float price;
	private boolean availability;
	private boolean valid;
	
	public Furniture(int id, User user, String name, String description, String type,Date postDate, float price, boolean availability, boolean valid ){
		super();
		this.id= id;
		this.user= user;
		this.name= name;
		this.description= description;
		this.type= type;
		this.postDate= postDate;
		this.price= price;
		this.availability= availability;
		this.valid= valid;
			
	}
	
	public Furniture() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*public OrderFurnitureEntity getOrder() {
		return order;
	}

	public void setOrder(OrderFurnitureEntity order) {
		this.order = order;
	}*/

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
	
	
	
	
	

}
