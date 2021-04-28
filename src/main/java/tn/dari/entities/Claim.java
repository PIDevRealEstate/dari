package tn.dari.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Claim implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int idClaim ; 
	
	private String objectOfClaim;
	private String description ;
	@Temporal(TemporalType.DATE)
	private Date dateOfClaim;
	private boolean status; // "True" if administrator accepted request or "False" if on hold
	
	@Enumerated(EnumType.STRING)
	private ClaimType typeClaim;
	
	@ManyToOne
	private User user ; 
	
	
	
	
	public Claim() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Claim(int idClaim, String objectOfClaim, String description, ClaimType typeClaim) {
		super();
		this.idClaim = idClaim;
		this.objectOfClaim = objectOfClaim;
		this.description = description;
		//this.dateOfClaim = dateOfClaim;
		this.typeClaim = typeClaim;
	}
	
	
	
	public int getIdClaim() {
		return idClaim;
	}
	public void setIdClaim(int idClaim) {
		this.idClaim = idClaim;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getObjectOfClaim() {
		return objectOfClaim;
	}
	public void setObjectOfClaim(String objectOfClaim) {
		this.objectOfClaim = objectOfClaim;
	}
	public Date getDateOfClaim() {
		return dateOfClaim;
	}
	public void setDateOfClaim(Date dateOfClaim) {
		this.dateOfClaim = dateOfClaim;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public ClaimType getTypeClaim() {
		return typeClaim;
	}
	public void setTypeClaim(ClaimType typeClaim) {
		this.typeClaim = typeClaim;
	} 
	
	
	
	

}
