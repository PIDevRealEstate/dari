package com.dari.model;

import javax.persistence.*;

@Entity
@Table(name = "meetings")
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMeeting;
    private String typeMeeting;


    public Long getIdMeeting() {
        return idMeeting;
    }

    public void setIdMeeting(Long idMeeting) {
        this.idMeeting = idMeeting;
    }

    public String getTypeMeeting() {
        return typeMeeting;
    }

    public void setTypeMeeting(String typeMeeting) {
        this.typeMeeting = typeMeeting;
    }
}
