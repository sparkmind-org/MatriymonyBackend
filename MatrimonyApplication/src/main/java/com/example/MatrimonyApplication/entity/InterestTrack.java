package com.example.MatrimonyApplication.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "interest_tracking")
public class InterestTrack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "receiver_profile_id", nullable = false)
    private String receiverProfileId;

    @Column(name = "sender_profile_id", nullable = false)
    private String senderProfileId;

    @Column(name = "interest_created_on", nullable = true)
    private LocalDateTime interestCreatedOn;

    @Column(name = "interest_last_updated_on", nullable = true)
    private LocalDateTime interestLastUpdatedOn;
}
