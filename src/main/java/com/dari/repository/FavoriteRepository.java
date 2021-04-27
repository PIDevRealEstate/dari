package com.dari.repository;

import com.dari.model.Ad;
import com.dari.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
}
