package tn.dari.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.dari.entities.Furniture;

@Repository
public interface FurnitureRepository extends CrudRepository<Furniture, Integer>, JpaRepository<Furniture, Integer> {
	
	public List<Furniture> findByName(String name);
	public List<Furniture> findByType(String type);
	//public List<Furniture> findByPriceAsc();
	
	@Query("SELECT f FROM Furniture f WHERE f.availability=1 and f.valid=1")
	public List<Furniture> getFurnitureAvailable();
}
