package tn.dari.services;


import tn.dari.entities.Meeting;

public interface MeetingService {
    public  int createMeeting(Meeting meeting);
    public  int updateMeeting(Meeting meeting);
    public  void deleteMeeting(Long id);
}
