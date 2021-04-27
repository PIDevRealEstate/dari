package com.dari.service;

import com.dari.model.Favorite;
import com.dari.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteServiceImpl implements FavoriteService{

    @Autowired
    FavoriteRepository favoriteRepository;

    @Override
    public int createFavorite(Favorite favorite) {
        this.favoriteRepository.save(favorite);
        return 1;
    }


    @Override
    public void deleteFavorite(Long id) {
        this.favoriteRepository.deleteById(id);
    }
}
