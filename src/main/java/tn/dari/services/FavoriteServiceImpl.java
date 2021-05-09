package tn.dari.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.dari.entities.Favorite;
import tn.dari.repositories.FavoriteRepository;

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
