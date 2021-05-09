package tn.dari.services;


import tn.dari.entities.Favorite;

public interface FavoriteService {
    public  int createFavorite(Favorite favorite);
    public  void deleteFavorite(Long id );
}
