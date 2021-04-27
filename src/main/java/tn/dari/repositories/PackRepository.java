package tn.dari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.dari.entities.Pack;



@Repository
public interface PackRepository extends JpaRepository<Pack, Integer> {
  
}
