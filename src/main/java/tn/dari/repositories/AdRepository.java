package tn.dari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.dari.entities.Ad;

public interface AdRepository extends JpaRepository<Ad, Long> {
}
