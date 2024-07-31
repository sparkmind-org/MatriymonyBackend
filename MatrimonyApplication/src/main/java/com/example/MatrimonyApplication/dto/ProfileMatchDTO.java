package com.example.MatrimonyApplication.dto;

import lombok.Data;

@Data
public class ProfileMatchDTO {

    private String profileId;
    private String matchedProfileId;

    public ProfileMatchDTO( String profileId, String matchedProfileId) {

        this.profileId = profileId;
        this.matchedProfileId = matchedProfileId;
    }

}
