package tn.dari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.dari.entities.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
}
