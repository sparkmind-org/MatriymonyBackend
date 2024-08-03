package com.example.MatrimonyApplication.dto;

import lombok.Data;

@Data
public class ProfileInterestDTO {
    private String profileId;
    private long interestCount;

    // Constructor
    public ProfileInterestDTO(String profileId, long interestCount) {
        this.profileId = profileId;
        this.interestCount = interestCount;
    }
}
