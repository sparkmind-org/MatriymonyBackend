package com.example.MatrimonyApplication.repository;

import com.example.MatrimonyApplication.entity.ProfileImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileImagesRepository extends JpaRepository<ProfileImages, Long> {
    ProfileImages findByProfileId(String profileId);
}
