package com.example.MatrimonyApplication.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class ProfileVisits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String visitToProfile;

    @Column(nullable = true)
    private String visitFromProfile;

    @Column(nullable = true)
    private LocalDateTime lastVisitedOn;

    @Column(nullable = true)
    private Integer visitCount;

    // Getters and Setters

}
