package tn.dari.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Meeting implements Serializable{
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idMeeting ; 
	private String typeMeeting ;
	
	@ManyToOne
	private Pub pub ;
	
	public int getIdMeeting() {
		return idMeeting;
	}
	public void setIdMeeting(int idMeeting) {
		this.idMeeting = idMeeting;
	}
	public String getTypeMeeting() {
		return typeMeeting;
	}
	public void setTypeMeeting(String typeMeeting) {
		this.typeMeeting = typeMeeting;
	}
	
	
	

}
