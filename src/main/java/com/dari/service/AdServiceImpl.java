package com.dari.service;

import com.dari.model.Ad;
import com.dari.model.Favorite;
import com.dari.model.Meeting;
import com.dari.repository.AdRepository;
import com.dari.repository.FavoriteRepository;
import com.dari.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdServiceImpl implements  AdService{
    @Autowired
    AdRepository adRepository;
    @Autowired
    MeetingRepository meetingRepository;
    @Autowired
    FavoriteRepository favoriteRepository;

    @Override
    public int createAd(Ad ad) {
        try {
            this.adRepository.save(ad);
            return 1;
        }catch (Exception e){
            return 0;
        }


    }

    @Override
    public int updateAd(Ad ad) {
        this.adRepository.findById(ad.getId()).ifPresent(ad1 -> {
            ad1.setAddDate(ad.getAddDate());
            ad1.setHaveGarage(ad.isHaveGarage());
            ad1.setHaveGarden(ad.isHaveGarden());
            ad1.setHaveSwimmingPool(ad.isHaveSwimmingPool());
            ad1.setHaveParking(ad.isHaveParking());
            ad1.setNbOfRooms(ad.getNbOfRooms());
            ad1.setPrice(ad.getPrice());
            ad1.setType(ad.getType());
            ad1.setNbOfBathRooms(ad.getNbOfBathRooms());
            ad1.setFavorite(ad.getFavorite());
            this.adRepository.save(ad1);
        });
        return 1;
    }

    @Override
    public void deleteAd(Long id) {
        this.adRepository.deleteById(id);

    }

    @Override
    public int addMeeting(Long id, Meeting meeting) {
        this.meetingRepository.save(meeting);
        this.adRepository.findById(id).ifPresent(ad -> {
            ad.setMeetingList(meeting);
            this.adRepository.save(ad);
        });
        return 1;
    }

    @Override
    public int isFavorite(Long id,Favorite favorite) {
        this.adRepository.findById(id).ifPresent(ad -> {
            favorite.setAd(ad);
            this.favoriteRepository.save(favorite);
            ad.setFavorite(favorite);
            this.adRepository.save(ad);
        });
        return 1;
    }

    @Override
    public List<Ad> getAll() {
        return this.adRepository.findAll();
    }

    @Override
    public void deleteMeetingFromAd(Long idAd, Long idMeeting) {
        Meeting meeting =meetingRepository.findById(idMeeting).get();
        Ad ad = adRepository.findById(idAd).get();
        ad.getMeetingList().remove(meeting);
        adRepository.save(ad);
        meetingRepository.deleteById(idMeeting);
    }

    @Override
    public List<Ad> filter(Ad ad) {
         return adRepository.findAll().stream()
                .filter(ad1 -> ad1.isHaveGarage()==ad.isHaveGarage())
                .filter(ad1 -> ad1.isHaveParking()==ad.isHaveParking())
                .filter(ad1 -> ad1.isHaveSwimmingPool()==ad.isHaveSwimmingPool())
                .filter(ad1 -> ad1.isHaveGarden()==ad.isHaveGarden())
                .filter(ad1 -> ad1.getPrice()==ad.getPrice())
                .filter(ad1 -> ad1.getNbOfBathRooms()==ad.getNbOfBathRooms())
                .filter(ad1 -> ad1.getNbOfRooms()==ad.getNbOfRooms())
                .filter(ad1 -> ad1.getType()==ad.getType())
                .collect(Collectors.toList());
    }

    @Override
    public List<Ad> getByType(String type) {
        return adRepository.findAll().stream()
                .filter(ad1 -> ad1.getType()==type)
                .collect(Collectors.toList());
    }

    @Override
    public List<Ad> getByPrice(float min, float max) {
        return adRepository.findAll().stream()
                .filter(ad1 -> ad1.getPrice()>=min&&ad1.getPrice()<=max)
                .collect(Collectors.toList());
    }

    @Override
    public List<Ad> getByRooms(Long min,Long max) {
        return adRepository.findAll().stream()
                .filter(ad1 -> ad1.getNbOfRooms()>=min&&ad1.getNbOfRooms()<=max)
                .collect(Collectors.toList());
    }

    @Override
    public List<Ad> getByBathRooms(Long min,Long max) {
        return adRepository.findAll().stream()
                .filter(ad1 -> ad1.getNbOfBathRooms()>=min  && ad1.getNbOfBathRooms()<=max)
                .collect(Collectors.toList());
    }

    @Override
    public List<Ad> haveSwimmingPool(boolean bool) {
        return adRepository.findAll().stream()
                .filter(ad1 -> ad1.isHaveSwimmingPool()==bool)
                .collect(Collectors.toList());
    }

    @Override
    public List<Ad> haveGarage(boolean bool) {
        return adRepository.findAll().stream()
                .filter(ad1 -> ad1.isHaveGarage()==bool)
                .collect(Collectors.toList());
    }

    @Override
    public List<Ad> haveGarden(boolean bool) {
        return adRepository.findAll().stream()
                .filter(ad1 -> ad1.isHaveGarden()==bool)
                .collect(Collectors.toList());
    }

    @Override
    public List<Ad> haveParking(boolean bool) {
        return adRepository.findAll().stream()
                .filter(ad1 -> ad1.isHaveParking()==bool)
                .collect(Collectors.toList());
    }


}
