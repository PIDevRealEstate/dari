package tn.dari.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class ReplyClaim extends Claim implements Serializable  {
	
	
	public ReplyClaim(int idClaim, String objectOfClaim, String description, Date dateOfClaim, ClaimType typeClaim) {
		super(idClaim, objectOfClaim, description, typeClaim);
		// TODO Auto-generated constructor stub
	}
	private int idReply ; 
	private String comment ;
	
	
	public int getIdReply() {
		return idReply;
	}
	public void setIdReply(int idReply) {
		this.idReply = idReply;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	} 

}
