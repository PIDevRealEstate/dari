package com.dari.service;

import com.dari.model.Meeting;

public interface MeetingService {
    public  int createMeeting(Meeting meeting);
    public  int updateMeeting(Meeting meeting);
    public  void deleteMeeting(Long id);
}
