package tn.dari.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;

import tn.dari.entities.Claim;
import tn.dari.repositories.ClaimRepository;
import tn.dari.services.ClaimServices;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "*")
public class ClaimController {
	@Autowired
	ClaimRepository claimrepo;
	
	@Autowired
	ClaimServices claimserv;


	@GetMapping("/")
	@ResponseBody
	public String Hello() {
		return "hello world";

	}

	// Create
	// http://localhost:8081/Dari/servlet/addClaim/{iduser}
	@PostMapping("/addClaim")
	@ResponseBody
	public Claim addClaim( @RequestBody Claim C) {
		claimserv.addClaim(C);
		return C;
		
	}

	//Read
	
	// For Administrator shows claims that have status false (not treated yet)
	// http://localhost:8081/Dari/servlet/Claim/bystatus
	@GetMapping("/Claim/bystatus")
	@ResponseBody
	public List<Claim> afficherClaim() {
		return claimserv.getAllClaimByStatus();
	}
	
	@GetMapping("/Claim/all")
	@ResponseBody
	//public String getAllClaims() {
	//List<Claim> listclaims = claimserv.GetAllClaims();
	//return "message";
	public List<Claim> afficherClaims() {
		return claimserv.GetAllClaims();

	}
	
	// Modify Complaint
	// http://localhost:8081/Dari/servlet/updateClaim/{id}/{description}
	@PutMapping("/updateClaim/{id}/{description}")
	@ResponseBody
	/*public ResponseEntity<String> updateClaim(@PathVariable("id") int id,
			                                  @PathVariable("description") String description) {
	claimserv.updateDescriptionClaim(description, id);
	return new ResponseEntity<>("Modification reussie.", HttpStatus.OK);
	}*/
	public void updateClaim(@PathVariable("id") int id,  @PathVariable("description") String description){
		claimserv.updateDescriptionClaim(description, id);
	
	}
	

	
	// http://localhost:8081/Dari/servlet/Claim/delete/{id}
		@DeleteMapping("Claim/delete/{id}")
		@ResponseBody
		public void removeUser(@PathVariable("id") int idClaim) {
			claimserv.deleteClaim(idClaim);
		}
		/*public ResponseEntity<String> deleteClaim(@PathVariable("id") int id) {
			claimserv.deleteClaim(id);
			return new ResponseEntity<>("Suppression reussie.", HttpStatus.OK);
		}*/
	
		
		
		
		
		
		//@GetMapping("/Claim/byid/{id}")
		//public List<Claim> getclaimbyId() {
		//	return claimserv.getClaimById();
		
		//}
		/*@ResponseBody
		public List<Claim> retrieveclaim(@PathVariable("id") int id) {
		return claimserv.getClaimById();
		}*/
		
		// http://localhost:8081/Dari/servlet/Claim/all
		
		/*@GetMapping("/Claim/all")
		public List<Claim> getallclaim() {
			return claimserv.GetAllClaims();
		}*/
		
		
				
		/*public ResponseEntity<String> ajouterComplaint(@PathVariable("iduser") int iduser,@RequestBody Claim C) {*/
		//	claimserv.addClaim(C);
		//	return new ResponseEntity<>("Successful add", HttpStatus.CREATED);
		//}
		
}
