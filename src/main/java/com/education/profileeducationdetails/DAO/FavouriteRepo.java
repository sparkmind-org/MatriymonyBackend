package com.education.profileeducationdetails.DAO;

import com.education.profileeducationdetails.enities.FavouriteTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavouriteRepo extends JpaRepository<FavouriteTracking, Long> {

    Optional<FavouriteTracking> findBySenderProfileIdAndReceiverProfileId(String senderProfileId, String receiverProfileId);
    List<FavouriteTracking> findBySenderProfileId(String senderProfileId);

//    List<FavouriteTracking> findByProfileId(String profileId);
//    void deleteByProfileIdAndFavouriteProfileId(String profileId, String favouriteProfileId);
}
