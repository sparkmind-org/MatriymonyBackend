package com.example.MatrimonyApplication.controller;

import com.example.MatrimonyApplication.entity.Profile;
import com.example.MatrimonyApplication.entity.ProfileInfo;
import com.example.MatrimonyApplication.repository.ProfileInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profileInfo")
public class ProfileInfoController {

    @Autowired
    private ProfileInfoRepository profileInfoRepository;


    // Add a new profile info
    @PostMapping
    public ResponseEntity<ProfileInfo> addProfileInfo(@RequestBody ProfileInfo profileInfo) {
        Profile profile = profileInfo.getProfile();
        if (profile == null || profile.getProfileId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // Optionally, you may want to check if the Profile exists in the ProfileRepository

        ProfileInfo savedProfileInfo = profileInfoRepository.save(profileInfo);
        return new ResponseEntity<>(savedProfileInfo, HttpStatus.CREATED);
    }

    // Get a profile info by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProfileInfo> getProfileInfo(@PathVariable Long id) {
        Optional<ProfileInfo> profileInfo = profileInfoRepository.findById(id);
        if (profileInfo.isPresent()) {
            return new ResponseEntity<>(profileInfo.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get all profile info
    @GetMapping
    public ResponseEntity<List<ProfileInfo>> getAllProfileInfo() {
        List<ProfileInfo> profiles = profileInfoRepository.findAll();
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }

    // Update profile info by ID
    @PutMapping("/{id}")
    public ResponseEntity<ProfileInfo> updateProfileInfo(@PathVariable Long id, @RequestBody ProfileInfo updatedProfileInfo) {
        return profileInfoRepository.findById(id)
                .map(profile -> {
                    updatedProfileInfo.setId(profile.getId());
                    ProfileInfo savedProfile = profileInfoRepository.save(updatedProfileInfo);
                    return new ResponseEntity<>(savedProfile, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete profile info by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfileInfo(@PathVariable Long id) {
        return profileInfoRepository.findById(id)
                .map(profile -> {
                    profileInfoRepository.delete(profile);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
