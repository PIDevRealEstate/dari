package tn.dari.entities;

import com.sun.istack.NotNull;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String password;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@NotNull
	private String role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@ManyToMany
	private List<Furniture> favoris;
	
	public User(int id, String firstName, String lastName, String email, String password,List<Furniture> favoris) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.favoris = favoris;
	}
	public User() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	public List<Furniture> getFavoris() {
		return favoris;
	}
	public void setFavoris(List<Furniture> favoris) {
		this.favoris = favoris;
	}
	
	
	
	
	
	
	
	
	

	
	
	
}
