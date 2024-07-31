package com.example.MatrimonyApplication.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "profile_match")
@Data
public class ProfileMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    @Column(name = "matched_profile_id", nullable = false)
    private String matchedProfileId;
}
