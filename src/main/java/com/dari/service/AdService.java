package com.dari.service;

import com.dari.model.Ad;
import com.dari.model.Favorite;
import com.dari.model.Meeting;
import com.dari.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface AdService {
    public int createAd(Ad ad);
    public  int updateAd(Ad ad);
    public void deleteAd(Long id);
    public  int addMeeting(Long id ,Meeting meeting);
    public  int isFavorite(Long id, Favorite favorite);
    List<Ad> getAll();


    void deleteMeetingFromAd(Long idAd, Long idMeeting);

    List<Ad> filter(Ad ad);

    List<Ad> getByType(String type);

    List<Ad> getByPrice(float min, float max);

    List<Ad> getByRooms(Long min,Long max);

    List<Ad> getByBathRooms(Long min,Long max);

    List<Ad> haveSwimmingPool(boolean bool);

    List<Ad> haveGarage(boolean bool);

    List<Ad> haveGarden(boolean bool);

    List<Ad> haveParking(boolean bool);
}
