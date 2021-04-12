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
public  class User implements Serializable {
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
	private Role role ;
	
	@OneToMany
	private List<Pub> pubs ; 
	@OneToMany
	private List<CreditCard> creditCards ; 
	@OneToMany
	private List<Claim> claims ;
	@OneToOne
	private Subscription subscription ;
	@OneToMany
	private List<Furniture> furnitures ; 
	
	
	//////////	//////////   /////////	//////////
	@OneToMany (mappedBy="User")
	private List<OrderFurnitureEntity> order;
	
	public  List<OrderFurnitureEntity> getOrder() {
		return order ;
	}
	public void setOrder( List<OrderFurnitureEntity> order) {
		this.order = order;
	}
	//////////	//////////   /////////	//////////

	

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
	public User(int idUser, String email, String password, String firstName, String lastName, Role role) {
		super();
		this.idUser = idUser;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}
	public User(String email, String password, String firstName, String lastName, Role role) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}
	public User() {
		
	}
	
	

}
