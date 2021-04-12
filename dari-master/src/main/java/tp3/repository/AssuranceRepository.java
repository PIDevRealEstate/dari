package tp3.repository;

 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.dari.entities.Assurance;

@Repository
public interface AssuranceRepository extends CrudRepository<Assurance, Integer>{
 
}