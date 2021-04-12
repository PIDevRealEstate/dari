package tn.dari.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Contract {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private int reference;
	private Date dateDebut;
	private String Duree;
	
	@OneToOne(mappedBy="Contract")
	private Assurance assurance ;
	
	
	@OneToOne(mappedBy="contract")
	private Subscription subscription;
	@ManyToOne
	User user;
		
	public Assurance getAssurance() {
		return assurance;
	}
	public void setAssurance(Assurance assurance) {
		this.assurance = assurance;
	}

	public long getId() {
		return id;
	}
	public int getReference() {
		return reference;
	}
	public void setReference(int reference) {
		this.reference = reference;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public String getDuree() {
		return Duree;
	}
	public void setDuree(String duree) {
		Duree = duree;
	}
	public Subscription getSubscription() {
		return subscription;
	}
	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
	
	public Contract() {
		
		// TODO Auto-generated constructor stub
	}
}
	