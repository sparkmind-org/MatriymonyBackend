package com.example.MatrimonyApplication.service;

import com.example.MatrimonyApplication.dto.InterestDTO;
import com.example.MatrimonyApplication.dto.ProfileInterestDTO;
import com.example.MatrimonyApplication.entity.InterestTrack;
import com.example.MatrimonyApplication.repository.InterestTrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InterestTrackService {

    @Autowired
    private InterestTrackRepository repository;

    public InterestTrack sendInterest(String receiverProfileId, String senderProfileId) {
        // Check if sender and receiver are the same
        if (receiverProfileId.equals(senderProfileId)) {
            return null; // Interest cannot be sent to self
        }

        // Check if the interest already exists
        List<InterestTrack> existingInterests = repository.findByReceiverProfileIdAndSenderProfileId(receiverProfileId, senderProfileId);
        if (!existingInterests.isEmpty()) {
            return null; // Interest already exists
        }

        InterestTrack interest = new InterestTrack();
        interest.setReceiverProfileId(receiverProfileId);
        interest.setSenderProfileId(senderProfileId);
        interest.setInterestCreatedOn(LocalDateTime.now());
        interest.setInterestLastUpdatedOn(LocalDateTime.now());
        return repository.save(interest);
    }

    public List<InterestDTO> getInterests(String receiverProfileId) {
        List<InterestTrack> interests = repository.findByReceiverProfileId(receiverProfileId);
        return interests.stream()
                .map(i -> new InterestDTO(i.getSenderProfileId(), i.getReceiverProfileId(), i.getInterestCreatedOn()))
                .collect(Collectors.toList());
    }

    public ProfileInterestDTO mostInterested() {
        List<Object[]> result = repository.findMostInterested();
        if (result.isEmpty()) {
            return null;
        }
        Object[] mostInterestedProfile = result.get(0);
        return new ProfileInterestDTO((String) mostInterestedProfile[0], (long) mostInterestedProfile[1]); // Return profile ID and interest count
    }

    public ProfileInterestDTO leastInterested() {
        List<Object[]> result = repository.findLeastInterested();
        if (result.isEmpty()) {
            return null;
        }
        Object[] leastInterestedProfile = result.get(0);
        return new ProfileInterestDTO((String) leastInterestedProfile[0], (long) leastInterestedProfile[1]); // Return profile ID and interest count
    }
}
