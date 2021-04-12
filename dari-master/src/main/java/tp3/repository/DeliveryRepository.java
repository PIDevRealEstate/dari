package tp3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.dari.entities.Delivery;


@Repository
public interface DeliveryRepository extends CrudRepository <Delivery, Integer>{

}
