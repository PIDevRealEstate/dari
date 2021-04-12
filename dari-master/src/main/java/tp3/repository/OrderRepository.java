package tp3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.dari.entities.OrderFurnitureEntity;

@Repository
public interface OrderRepository extends CrudRepository <OrderFurnitureEntity, Integer>{

}
