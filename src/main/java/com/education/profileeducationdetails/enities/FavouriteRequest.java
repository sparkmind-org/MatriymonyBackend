package com.education.profileeducationdetails.enities;


import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class FavouriteRequest {

    private String senderProfileId;
    private String receiverProfileId;
}
