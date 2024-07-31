package com.example.MatrimonyApplication.repository;

import com.example.MatrimonyApplication.entity.ProfileVisits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProfileVisitsRepository extends JpaRepository<ProfileVisits, Long> {
    List<ProfileVisits> findByVisitToProfile(String visitToProfile);
    List<ProfileVisits> findByVisitToProfileAndLastVisitedOnAfter(String visitToProfile, LocalDateTime timeRange);
    Optional<ProfileVisits> findByVisitToProfileAndVisitFromProfile(String visitToProfile, String visitFromProfile);

    // Fetch the most recent visit
    ProfileVisits findTopByVisitToProfileOrderByLastVisitedOnDesc(String visitToProfile);
}
