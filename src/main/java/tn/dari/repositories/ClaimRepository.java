package tn.dari.repositories;


import tn.dari.entities.Claim;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ClaimRepository extends CrudRepository<Claim, Integer> {
	
	public Claim findByIdClaim(int id); 
	
	@Query(" SELECT c FROM Claim c WHERE c.idClaim = :id ")
	List<Claim> retreiveClaimById(@Param("id") int id);  
	
	
	// **********************************************public void deleteById(int idClaim);  
	
	@Modifying
    @Query("UPDATE Claim c SET c.description=:description1 where c.idClaim=:id")
    public void updateDescriptionComplaintJPQL(@Param("description1")String description,
    		                                   @Param("id")int id);

	public List<Claim> findByStatusFalse();
	//@Query("SELECT c FROM Complain c WHERE c.status = :stat")
	//List<Claim> getAllClaimByStatus(@Param("stat") boolean status); 
	
	public List<Claim> findAll();

}
