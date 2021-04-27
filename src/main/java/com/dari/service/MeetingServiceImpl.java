package com.dari.service;

import com.dari.model.Meeting;
import com.dari.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeetingServiceImpl implements MeetingService{
    @Autowired
    MeetingRepository meetingRepository;
    @Override
    public int createMeeting(Meeting meeting) {
        this.meetingRepository.save(meeting);
        return 1;
    }

    @Override
    public int updateMeeting(Meeting meeting) {
        this.meetingRepository.findById(meeting.getIdMeeting()).ifPresent(meeting1 -> {
            meeting1.setTypeMeeting(meeting.getTypeMeeting());
            this.meetingRepository.save(meeting1);
        });
        return 1;
    }

    @Override
    public void deleteMeeting(Long id) {
        this.meetingRepository.deleteById(id);
    }
}
