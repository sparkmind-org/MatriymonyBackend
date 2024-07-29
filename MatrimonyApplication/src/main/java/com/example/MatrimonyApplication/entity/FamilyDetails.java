package com.example.MatrimonyApplication.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FamilyDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    @Column(name = "fathers_name", nullable = false)
    private String fathersName;

    @Column(name = "mothers_name", nullable = false)
    private String mothersName;

    private String brother;
    private String sister;
    private String marriedBrother;
    private String marriedSister;

    @Column(name = "fathers_occupation", nullable = false)
    private String fathersOccupation;

    private String mothersOccupation;

    @Column(name = "family_location", nullable = false)
    private String familyLocation;

    private String familyIncome;
    private String familyInfo;

    // Getters and Setters

}
