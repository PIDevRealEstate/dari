package tn.dari.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Pub implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idAdd ;
	
	private String type ; 
	
	private float prices ;
	
	@Temporal(TemporalType.DATE)
	private Date addDate ; 
	
	private int nbRooms ; 
	
	private int nbBathroom ; 
	
	private boolean swimpool ; 
	
	private boolean garage ; 
	
	private boolean  garden ; 
	
	private boolean parking ;
	
	@ManyToOne
	private User user ; 
	
	@OneToMany
	private List<Meeting> meetings ; 
	
	public int getIdAdd() {
		return idAdd;
	}
	public void setIdAdd(int idAdd) {
		this.idAdd = idAdd;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getPrices() {
		return prices;
	}
	public void setPrices(float prices) {
		this.prices = prices;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public int getNbRooms() {
		return nbRooms;
	}
	public void setNbRooms(int nbRooms) {
		this.nbRooms = nbRooms;
	}
	public int getNbBathroom() {
		return nbBathroom;
	}
	public void setNbBathroom(int nbBathroom) {
		this.nbBathroom = nbBathroom;
	}
	public boolean isSwimpool() {
		return swimpool;
	}
	public void setSwimpool(boolean swimpool) {
		this.swimpool = swimpool;
	}
	public boolean isGarage() {
		return garage;
	}
	public void setGarage(boolean garage) {
		this.garage = garage;
	}
	public boolean isGarden() {
		return garden;
	}
	public void setGarden(boolean garden) {
		this.garden = garden;
	}
	public boolean isParking() {
		return parking;
	}
	public void setParking(boolean parking) {
		this.parking = parking;
	}
	
	
	


}
