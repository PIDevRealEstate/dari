package tn.dari.services;

import java.util.List;

import tn.dari.entities.Claim;


public interface ClaimServices {

	//public void AddClaim(Claim claim);
	//	void DeleteClaim(String id);
	//	Claim FindClaim(String id);
	//	List<Claim> GetClaim();
	//	public void affecterreclamationUser(String idReclamation,String IdUser);
	//	public void AddClaimUser (Claim claim,String IdUser);
	
	public List<Claim> getClaimById();
	
	public List<Claim> getAllClaimByStatus();
	//public void acceptComplaint(int id);
	public void addClaim(Claim clai);
	public void deleteClaim(int idClaim);
	public void updateDescriptionClaim(String description, int idClaim);
	
	public List<Claim> GetAllClaims();
	
}
