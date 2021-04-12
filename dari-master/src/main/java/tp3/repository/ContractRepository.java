package tp3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.dari.entities.Contract;

@Repository
public interface ContractRepository extends CrudRepository<Contract, Long>{
	@Query(value = "SELECT * FROM contract tc WHERE tc.typecontract = :t " , nativeQuery =true)
	List<Contract> findByType(@Param("t")String typecontract);
	//	List<Contract> findByReferenceAndDateDebutAndTypeContrat(int c,Date d,String t);
	//List<Contract> getContractByReferenceAndDateDebutAndTypeContrat(@Param("c1")int c,@Param Date d,@Param String t);
	//@Query(value = "SELECT * FROM contract c WHERE c.typecontract = :t  and c.reference=:c1 and c.datedebut=:d" , nativeQuery =true)
	//@Query(value = "SELECT * FROM contract tc WHERE tc.datedebut = :d " , nativeQuery =true)
	//List<Contract> findByDate(@Param("d")Date datedebut);
	//@Query(value = "SELECT * FROM contract tc WHERE tc.datedebut = :d  and tc.typecontract = :t" , nativeQuery =true)
	//List<Contract> findByDateAndType(@Param("d")Date datedebut,@Param("t")String typecontract);
	//@Query(value = "SELECT * FROM contract tc WHERE tc.datedebut = :d " , nativeQuery =true)
	//List<Contract> findByDate(@Param("d")String datedebut);
	//List<Contract> findByDate(Date datedebut);
	//List<Contract> findContractByTypecontract(String typecontract);
	//List<Contract> findContractByDateDebut(Date datedebut);
	@Query(value = "SELECT * FROM contract WHERE id=?1", nativeQuery = true)
	public Contract getOne(Long id);
}