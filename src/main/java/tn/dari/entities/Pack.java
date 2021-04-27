package tn.dari.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pack implements Serializable{
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id ; 
	
    private String typePack ; 
    private int price ; 
    private String devise ;
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTypePack() {
		return typePack;
	}
	public void setTypePack(String typePack) {
		this.typePack = typePack;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDevise() {
		return devise;
	}
	public void setDevise(String devise) {
		this.devise = devise;
	}
	@Override
	public String toString() {
		return "Pack [id=" + id + ", typePack=" + typePack + ", price=" + price + ", devise=" + devise + "]";
	}
	
	public Pack(String typePack, int price, String devise) {
		super();
		this.typePack = typePack;
		this.price = price;
		this.devise = devise;
	}
	public Pack(int id, String typePack, int price, String devise) {
		super();
		this.id = id;
		this.typePack = typePack;
		this.price = price;
		this.devise = devise;
	}
	public Pack() {
		super();
	} 
    
    
    
}
