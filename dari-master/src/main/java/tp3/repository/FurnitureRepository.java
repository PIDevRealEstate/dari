package tp3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.dari.entities.Furniture;

@Repository
public interface FurnitureRepository extends CrudRepository <Furniture, Integer> {

	@Query("SELECT TitleFurniture FROM Furniture") // prix and title
    public List<String> FurnitureTitle();
	
	@Query("select * from Furniture f where f.TitleFurniture =: %Title%")
	public List<Furniture> findAllFurnitureByNameJPQL(@Param("Title")String TitleFurniture);
	
	@Query("select * from Furniture f where f.Prix BETWEEN  'MinPrix' AND 'MaxPrix'")
	public List<Furniture> findAllFurnitureByMaxMinPrixJPQL(@Param("MinPrix")int MinPrix, @Param("MaxPrix")int MaxPrix );
}
