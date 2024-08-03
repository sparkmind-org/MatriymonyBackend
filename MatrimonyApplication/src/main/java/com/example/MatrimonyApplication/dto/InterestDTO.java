package com.example.MatrimonyApplication.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InterestDTO {
    private String receiverProfileId;
    private String senderProfileId;
    private LocalDateTime interestCreatedOn;

    // Constructor
    public InterestDTO(String senderProfileId, String receiverProfileId, LocalDateTime interestCreatedOn) {
        this.senderProfileId = senderProfileId;
        this.receiverProfileId = receiverProfileId;
        this.interestCreatedOn = interestCreatedOn;
    }
}