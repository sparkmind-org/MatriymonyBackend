package com.example.MatrimonyApplication.repository;

import com.example.MatrimonyApplication.entity.InterestTrack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterestTrackRepository extends JpaRepository<InterestTrack, Long> {

    List<InterestTrack> findByReceiverProfileId(String receiverProfileId);

    List<InterestTrack> findByReceiverProfileIdAndSenderProfileId(String receiverProfileId, String senderProfileId);

    @Query("SELECT i.receiverProfileId, COUNT(i) as count FROM InterestTrack i GROUP BY i.receiverProfileId ORDER BY count DESC")
    List<Object[]> findMostInterested();

    @Query("SELECT i.receiverProfileId, COUNT(i) as count FROM InterestTrack i GROUP BY i.receiverProfileId ORDER BY count ASC")
    List<Object[]> findLeastInterested();
}
