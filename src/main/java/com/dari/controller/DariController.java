package com.dari.controller;

import com.dari.model.Ad;
import com.dari.model.Favorite;
import com.dari.model.Meeting;
import com.dari.service.AdServiceImpl;
import com.dari.service.FavoriteService;
import com.dari.service.FavoriteServiceImpl;
import com.dari.service.MeetingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/dari")
@CrossOrigin(origins = "*")

public class DariController {
    @Autowired
    AdServiceImpl adService;
    @Autowired
    MeetingServiceImpl meetingService;
    @Autowired
    FavoriteServiceImpl favoriteService;

    @PostMapping("/create-ad")
    public ResponseEntity<?> createAd(@RequestBody Ad ad){
        try {
            this.adService.createAd(ad);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);

        }

    }

    @PutMapping("/update-ad")
    public ResponseEntity<?> updateAd(@RequestBody Ad ad){
        try {
            this.adService.updateAd(ad);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);

        }}



    @DeleteMapping("/delete-ad/{id}")
    public ResponseEntity<?> deleteAd(@PathVariable Long id){
        try {
            this.adService.deleteAd(id);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);

        }

    }
    @DeleteMapping("/ad/{idAd}/delete-meeting/{idMeeting}")
    public ResponseEntity<?> deleteMeetingFromAd(@PathVariable Long idAd,@PathVariable Long idMeeting){
        try {
            this.adService.deleteMeetingFromAd(idAd,idMeeting);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);

        }

    }

    @DeleteMapping("/delete-favorite/{id}")
    public ResponseEntity<?> deleteFavorite(@PathVariable Long id){
        try {
            this.favoriteService.deleteFavorite(id);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);

        }

    }
    @PostMapping("/make-favorite-ad/{id}")
    public ResponseEntity<?> favoriteAd(@PathVariable Long id,@RequestBody Favorite favorite){
        try {
            this.adService.isFavorite(id,favorite);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);

        }

    }

    @PostMapping("/make-Meeting-ad")
    public ResponseEntity<?> meetingAd(@RequestParam("id") Long id,@RequestParam("meetingType") String meetingType){
        try {
            Meeting meeting = new Meeting();
            meeting.setTypeMeeting(meetingType);
            this.meetingService.createMeeting(meeting);
            this.adService.addMeeting(id,meeting);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);

        }

    }

    @GetMapping("/get-all")
    public List<Ad> getAll(){
        return this.adService.getAll();


    }

    @GetMapping("/get-by-type/{type}")
    public List<Ad> getByType(@PathVariable String type){
        return this.adService.getByType(type);

    }
    @GetMapping("/get-by-price/{min}/{max}")
    public List<Ad> getByPrice(@PathVariable float min,@PathVariable float max){
        return this.adService.getByPrice(min,max);

    }

    @GetMapping("/get-by-rooms/{min}/{max}")
    public List<Ad> getByRooms(@PathVariable Long min,@PathVariable Long max){
        return this.adService.getByRooms(min,max);

    }

    @GetMapping("/get-by-bathrooms/{min}/{max}")
    public List<Ad> getByBathRooms(@PathVariable Long min,@PathVariable Long max){
        return this.adService.getByBathRooms(min,max);

    }

    @GetMapping("/haveSwimmingPool/{bool}")
    public List<Ad> haveSwimmingPool(@PathVariable boolean bool){
        return this.adService.haveSwimmingPool(bool);

    }

    @GetMapping("/haveGarage/{bool}")
    public List<Ad> haveGarage(@PathVariable boolean bool){
        return this.adService.haveGarage(bool);

    }

    @GetMapping("/haveGarden/{bool}")
    public List<Ad> haveGarden(@PathVariable boolean bool){
        return this.adService.haveGarden(bool);

    }
    @GetMapping("/haveParking/{bool}")
    public List<Ad> haveParking(@PathVariable boolean bool){
        return this.adService.haveParking(bool);

    }
}
