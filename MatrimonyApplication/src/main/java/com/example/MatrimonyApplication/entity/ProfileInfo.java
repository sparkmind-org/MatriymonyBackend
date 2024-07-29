package com.example.MatrimonyApplication.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProfileInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private Integer age;
    private String bloodGroup;
    private String caste;
    private String religion;
    private String color;
    private String city;
    private String country;
    private String dob; // Date of Birth
    private String tob; // Time of Birth
    private String education;
    private String height;
    private String maritalStatus;
    private String profession;
    private String income;
    private String subcaste;
    private String description;
    private String uid;
    private String email;
    private String mobile;
    private String zodiacSign;
    private String gotra;
    private String devak;
    private String gender;
    private Boolean mangal;
    private Boolean pwd; // Person with Disability
    private Boolean spectacles;

    // Getters and Setters

}
