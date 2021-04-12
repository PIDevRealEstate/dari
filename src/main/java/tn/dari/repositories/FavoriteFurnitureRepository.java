package tn.dari.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.dari.entities.FavoriteFurniture;
import tn.dari.entities.Furniture;
import tn.dari.entities.User;

@Repository
public interface FavoriteFurnitureRepository extends CrudRepository<FavoriteFurniture, Integer>, JpaRepository<FavoriteFurniture, Integer> {
	@Query(value = "SELECT f FROM FavoriteFurniture f WHERE f.user=:user" + " AND f.furniture=:furniture")
	Optional<FavoriteFurniture> findfavoritenotbyid(@Param("user") User user, @Param("furniture") Furniture furniture);

}
