package com.example.MatrimonyApplication.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "profile_images", uniqueConstraints = @UniqueConstraint(columnNames = "profile_id"))
public class ProfileImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "profile_id", nullable = false, unique = true)
    private String profileId;


    @Column(name = "image", nullable = false)
    private byte[] image;
}
