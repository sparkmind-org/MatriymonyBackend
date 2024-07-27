package com.example.MatrimonyApplication.entity;

import jakarta.persistence.*;

@Entity
public class Lifestyle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    @Column(nullable = false)
    private String diet; // Veg/Non-Veg

    private Boolean drink; // Y/N
    private String languageInterest;
    private Boolean openToPets; // Y/N
    private Boolean smoking; // Y/N

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Boolean getDrink() {
        return drink;
    }

    public void setDrink(Boolean drink) {
        this.drink = drink;
    }

    public String getLanguageInterest() {
        return languageInterest;
    }

    public void setLanguageInterest(String languageInterest) {
        this.languageInterest = languageInterest;
    }

    public Boolean getOpenToPets() {
        return openToPets;
    }

    public void setOpenToPets(Boolean openToPets) {
        this.openToPets = openToPets;
    }

    public Boolean getSmoking() {
        return smoking;
    }

    public void setSmoking(Boolean smoking) {
        this.smoking = smoking;
    }
// Getters and Setters
}
