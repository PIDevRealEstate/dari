package tn.dari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.dari.entities.FavoriteFurniture;

@Repository
public interface FavoriteFurnitureRepository extends CrudRepository<FavoriteFurniture, Integer>, JpaRepository<FavoriteFurniture, Integer> {

}
