package com.dari.repository;

import com.dari.model.Favorite;
import com.dari.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
}
