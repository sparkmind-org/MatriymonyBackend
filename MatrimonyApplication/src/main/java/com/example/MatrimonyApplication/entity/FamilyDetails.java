package com.example.MatrimonyApplication.entity;

import jakarta.persistence.*;

@Entity
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getMothersName() {
        return mothersName;
    }

    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    public String getBrother() {
        return brother;
    }

    public void setBrother(String brother) {
        this.brother = brother;
    }

    public String getSister() {
        return sister;
    }

    public void setSister(String sister) {
        this.sister = sister;
    }

    public String getMarriedBrother() {
        return marriedBrother;
    }

    public void setMarriedBrother(String marriedBrother) {
        this.marriedBrother = marriedBrother;
    }

    public String getMarriedSister() {
        return marriedSister;
    }

    public void setMarriedSister(String marriedSister) {
        this.marriedSister = marriedSister;
    }

    public String getFathersOccupation() {
        return fathersOccupation;
    }

    public void setFathersOccupation(String fathersOccupation) {
        this.fathersOccupation = fathersOccupation;
    }

    public String getMothersOccupation() {
        return mothersOccupation;
    }

    public void setMothersOccupation(String mothersOccupation) {
        this.mothersOccupation = mothersOccupation;
    }

    public String getFamilyLocation() {
        return familyLocation;
    }

    public void setFamilyLocation(String familyLocation) {
        this.familyLocation = familyLocation;
    }

    public String getFamilyIncome() {
        return familyIncome;
    }

    public void setFamilyIncome(String familyIncome) {
        this.familyIncome = familyIncome;
    }

    public String getFamilyInfo() {
        return familyInfo;
    }

    public void setFamilyInfo(String familyInfo) {
        this.familyInfo = familyInfo;
    }
}
