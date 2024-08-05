package com.education.profileeducationdetails.services;

import com.education.profileeducationdetails.DAO.FavouriteRepo;
import com.education.profileeducationdetails.enities.FavouriteTracking;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FavouriteService {

    @Autowired
    private FavouriteRepo repo;

    @Transactional
    public FavouriteTracking addFavourite(String senderProfileId, String receiverProfileId) throws Exception {
        if (senderProfileId.equals(receiverProfileId)) {
            throw new IllegalArgumentException("You cannot add yourself as a favourite.");
        }

        // Check if this favourite relationship already exists
        if (repo.findBySenderProfileIdAndReceiverProfileId(senderProfileId, receiverProfileId).isPresent()) {
            throw new IllegalArgumentException("This favourite profile is already added.");
        }

        FavouriteTracking newFavourite = new FavouriteTracking();
        newFavourite. setSenderProfileId(senderProfileId);
        newFavourite.setReceiverProfileId(receiverProfileId);
        return repo.save(newFavourite);
    }

    public void removeFavourite(String senderProfileId, String receiverProfileId) {
        FavouriteTracking favourite = repo.findBySenderProfileIdAndReceiverProfileId(senderProfileId, receiverProfileId)
                .orElseThrow(() -> new IllegalArgumentException("Favourite profile not found."));
        repo.delete(favourite);
    }

    public List<FavouriteTracking> getAllFavourites(String profileId) {
        return repo.findBySenderProfileId(profileId);
    }
}

