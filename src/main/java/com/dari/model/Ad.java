package com.dari.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ads")
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private  String type;
    private float price;
    private Date addDate;
    private  Long nbOfRooms;
    private Long nbOfBathRooms;
    private  boolean haveSwimmingPool;
    private  boolean haveGarage;

    public Ad() {
        this.meetingList =new ArrayList<>();
    }

    public Favorite getFavorite() {
        return favorite;
    }

    public void setFavorite(Favorite favorite) {
        this.favorite = favorite;
    }

    public List<Meeting> getMeetingList() {
        return meetingList;
    }

    public void setMeetingList(Meeting meeting) {
        this.meetingList.add(meeting);
    }

    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Favorite favorite;

    @OneToMany
    private List<Meeting> meetingList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Long getNbOfRooms() {
        return nbOfRooms;
    }

    public void setNbOfRooms(Long nbOfRooms) {
        this.nbOfRooms = nbOfRooms;
    }

    public Long getNbOfBathRooms() {
        return nbOfBathRooms;
    }

    public void setNbOfBathRooms(Long nbOfBathRooms) {
        this.nbOfBathRooms = nbOfBathRooms;
    }

    public boolean isHaveSwimmingPool() {
        return haveSwimmingPool;
    }

    public void setHaveSwimmingPool(boolean haveSwimmingPool) {
        this.haveSwimmingPool = haveSwimmingPool;
    }

    public boolean isHaveGarage() {
        return haveGarage;
    }

    public void setHaveGarage(boolean haveGarage) {
        this.haveGarage = haveGarage;
    }

    public boolean isHaveGarden() {
        return haveGarden;
    }

    public void setHaveGarden(boolean haveGarden) {
        this.haveGarden = haveGarden;
    }

    public boolean isHaveParking() {
        return haveParking;
    }

    public void setHaveParking(boolean haveParking) {
        this.haveParking = haveParking;
    }

    private  boolean haveGarden;
    private  boolean haveParking;




}
