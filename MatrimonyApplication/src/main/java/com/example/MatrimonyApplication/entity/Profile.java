package com.example.MatrimonyApplication.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Profile {

    @Id
    private String profileId;

    @Column(nullable = false)
    private LocalDateTime createdOn;

    @Column(nullable = false)
    private LocalDateTime updatedOn;

    @Column(nullable = false)
    private Boolean active;

    @Column(nullable = false)
    private LocalDateTime lastSeen;

    @Column(nullable = false)
    private LocalDateTime lastLoggedIn;

     @OneToMany(mappedBy = "profile")
     @JsonManagedReference
    private List<Carrier> carriers;

    @OneToOne(mappedBy = "profile", cascade = CascadeType.ALL)
    @JsonManagedReference
    private ProfileInfo profileInfo;
    // Getters and Setters
}
