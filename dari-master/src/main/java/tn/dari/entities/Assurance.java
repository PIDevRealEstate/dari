package tn.dari.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Assurance implements Serializable{
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	
	private int IdAssurance ; 
		
	private String TitleAssurance ;

	private String description ;
	
	@OneToOne
	private Contract contract;

	
	
	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	public String getTitleAssurance() {
		return TitleAssurance;
	}
	public void setTitleAssurance(String titleAssurance) {
		TitleAssurance = titleAssurance;
	}
	
	public int getIdAssurance() {
		return IdAssurance;
	}
	public void setIdAssurance(int idClaim) {
		this.IdAssurance = IdAssurance;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	} 
	
	public Assurance() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
