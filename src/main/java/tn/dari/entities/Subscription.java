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
	private int idSub ; 
	@Temporal(TemporalType.DATE)
	private Date beginSub ;
	@Temporal(TemporalType.DATE)
	private Date endSub ;
	
	@OneToOne
	private User user ;
	
	
	
	public int getIdSub() {
		return idSub;
	}
	public void setIdSub(int idSub) {
		this.idSub = idSub;
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

}
