package com.dari.service;

import com.dari.model.Favorite;

public interface FavoriteService {
    public  int createFavorite(Favorite favorite);
    public  void deleteFavorite(Long id );
}
