package tn.dari.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.dari.entities.Claim;
import tn.dari.repositories.ClaimRepository;


@Service
public class ClaimServicesImpl implements ClaimServices {
	
	@Autowired
	ClaimRepository claimrepo;
	
	 private static final Logger L = LogManager.getLogger(ClaimServicesImpl.class);

	@Override
	public List<Claim> getClaimById() {
		int id = 0;
    	return claimrepo.retreiveClaimById(id);
	}

	@Override
	public List<Claim> getAllClaimByStatus() {
		//return null;
		return claimrepo.findByStatusFalse();
	}

	@Override
	public void addClaim(Claim clai) {
		claimrepo.save(clai);
	}

	@Override
	public void deleteClaim(int idClaim) {
		claimrepo.deleteById(idClaim);
	}

	@Override
	public void updateDescriptionClaim(String description, int idClaim) {
		
		Claim c=claimrepo.findById(idClaim).get();
		c.setDescription(description);
		claimrepo.save(c);
	}

	@Override
	public List<Claim> GetAllClaims() {
		//return null;
		return claimrepo.findAll() ;
	}
	
	//------------------------------
	//List deslist = description.split 
	//for i in deslist
	//if i in list(dictionnaire)
	//return 
	//else ...
	
}
