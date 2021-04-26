package tn.dari.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class FavoriteFurniture implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	private User user;
	@ManyToMany
	private List<Furniture> furniture;
	
	
	public FavoriteFurniture(int id, User user, List<Furniture> furniture) {
		super();
		this.id = id;
		this.user = user;
		this.furniture = furniture;
	}
	
	
	public FavoriteFurniture() {
		
	}
	
	public void setFurniture(List<Furniture> furniture) {
		this.furniture = furniture;
	}



	public List<Furniture> getFurniture() {
		return furniture;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	

}
