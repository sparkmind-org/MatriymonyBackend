package com.example.MatrimonyApplication.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
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

}
