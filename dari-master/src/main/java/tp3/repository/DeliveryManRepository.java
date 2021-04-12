package tp3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.dari.entities.DeliveryMan;
import tn.dari.entities.LesGouvernorat;

@Repository
public interface DeliveryManRepository extends CrudRepository <DeliveryMan, Integer> {
 
	@Query("SELECT * FROM DeliveryMan") // prix and title
    public List<DeliveryMan> findAllDeliveryMan();
	
	
	@Query("SELECT * FROM DeliveryMan D WHERE D.gouvernorat =: g ") // prix and title
    public List<DeliveryMan> findAllDeliveryManByGouvernorat(@Param("g")LesGouvernorat gouvernorat);
}
