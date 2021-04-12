package tn.dari.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.dari.entities.OrderFurnitureEntity;

@Repository
public interface OrderFurnitureRepository extends CrudRepository<OrderFurnitureEntity, Integer>,JpaRepository<OrderFurnitureEntity, Integer> {

	
	@Transactional
	@Modifying
	@Query("Delete FROM OrderFurnitureEntity f WHERE f.id=:id")
	public void deleteOrders(@Param("id")int id);

}
