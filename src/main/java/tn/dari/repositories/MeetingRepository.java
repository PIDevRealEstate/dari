package tn.dari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.dari.entities.Meeting;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
}
