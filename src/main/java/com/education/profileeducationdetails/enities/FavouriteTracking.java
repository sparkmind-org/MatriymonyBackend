package com.education.profileeducationdetails.enities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "FavouriteTracking", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"profileId", "favouriteprofileId"})
})
public class FavouriteTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "profile_id", nullable = false)
    private String senderProfileId;

    @Column(name = "favourite_profile_id", nullable = true)
    private String receiverProfileId;
}
