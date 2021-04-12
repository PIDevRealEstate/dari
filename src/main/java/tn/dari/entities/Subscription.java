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
public class Subscription implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id ; 
	private String name ; 
	@Temporal(TemporalType.DATE)
	private Date beginSub ;
	@Temporal(TemporalType.DATE)
	private Date endSub ;
	
	@OneToOne
	private User user ;
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getBeginSub() {
		return beginSub;
	}
	public void setBeginSub(Date beginSub) {
		this.beginSub = beginSub;
	}
	public Date getEndSub() {
		return endSub;
	}
	public void setEndSub(Date endSub) {
		this.endSub = endSub;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Subscription(String name, Date beginSub, Date endSub) {
		super();
		this.name = name;
		this.beginSub = beginSub;
		this.endSub = endSub;
		
	}
	public Subscription() {
		
	} 

}
