package com.example.MatrimonyApplication.service;

import com.example.MatrimonyApplication.entity.ProfileVisits;
import com.example.MatrimonyApplication.repository.ProfileVisitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileVisitsService {
    private static final Logger logger = LoggerFactory.getLogger(ProfileVisitsService.class);

    @Autowired
    private ProfileVisitsRepository profileVisitsRepository;

    @Transactional
    public ProfileVisits recordProfileVisit(String visitToProfile, String visitFromProfile) {
        logger.info("Recording profile visit from {} to {}", visitFromProfile, visitToProfile);
        Optional<ProfileVisits> optionalProfileVisit = profileVisitsRepository.findByVisitToProfileAndVisitFromProfile(visitToProfile, visitFromProfile);

        ProfileVisits profileVisit;
        if (optionalProfileVisit.isEmpty()) {
            profileVisit = new ProfileVisits();
            profileVisit.setVisitToProfile(visitToProfile);
            profileVisit.setVisitFromProfile(visitFromProfile);
            profileVisit.setVisitCount(1);
        } else {
            profileVisit = optionalProfileVisit.get();
            profileVisit.setVisitCount(profileVisit.getVisitCount() + 1);
        }

        profileVisit.setLastVisitedOn(LocalDateTime.now());
        return profileVisitsRepository.save(profileVisit);
    }

    public List<ProfileVisits> getAllProfileVisits(String profileId) {
        logger.info("Fetching all profile visits for profile {}", profileId);
        return profileVisitsRepository.findByVisitToProfile(profileId);
    }

    public List<ProfileVisits> getRecentlyVisited(String profileId, LocalDateTime timeRange, int limit) {
        logger.info("Fetching recently visited profiles for {} since {}", profileId, timeRange);
        return profileVisitsRepository.findByVisitToProfileAndLastVisitedOnAfter(profileId, timeRange).stream().limit(limit).toList();
    }

    public ProfileVisits getMostRecentVisit(String profileId) {
        logger.info("Fetching most recent visit for profile {}", profileId);
        return profileVisitsRepository.findTopByVisitToProfileOrderByLastVisitedOnDesc(profileId);
    }
}
