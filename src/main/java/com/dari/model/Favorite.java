package com.dari.model;

import javax.persistence.*;

@Entity
@Table(name = "Favorites")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idFavorite;

    @OneToOne
    private Ad ad;

    public Long getIdFavorite() {
        return idFavorite;
    }


    public void setAd(Ad ad) {
        this.ad = ad;
    }

    public void setIdFavorite(Long idFavorite) {
        this.idFavorite = idFavorite;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    private boolean available;


}
