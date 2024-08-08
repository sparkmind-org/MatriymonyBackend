package com.example.MatrimonyApplication.controller;

import com.example.MatrimonyApplication.entity.Profile;
import com.example.MatrimonyApplication.repository.ProfileRepository;
import com.example.MatrimonyApplication.service.ProfileIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController("customProfileController")
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
     private ProfileRepository profileRepository;

    @Autowired
    private ProfileIdGenerator profileIdGenerator;

    @PostMapping
    public Profile addProfile(@RequestBody Profile profile) {
        profile.setProfileId(profileIdGenerator.generateProfileId());
        profile.setCreatedOn(LocalDateTime.now());
        profile.setUpdatedOn(LocalDateTime.now());
        profile.setActive(true); // assuming new profiles are active by default
        return profileRepository.save(profile);
    }

    @GetMapping("/{id}")
    public Profile getProfile(@PathVariable String id) {
        return profileRepository.findById(id).orElseThrow(() -> new RuntimeException("Profile not found"));
    }

    @GetMapping
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    @PutMapping("/{id}")
    public Profile updateProfile(@PathVariable String id, @RequestBody Profile updatedProfile) {
        Profile profile = profileRepository.findById(id).orElseThrow(() -> new RuntimeException("Profile not found"));
        profile.setUpdatedOn(LocalDateTime.now());
        profile.setActive(updatedProfile.getActive());
        profile.setLastSeen(updatedProfile.getLastSeen());
        profile.setLastLoggedIn(updatedProfile.getLastLoggedIn());
        return profileRepository.save(profile);
    }

    @DeleteMapping("/{id}")
    public void deleteProfile(@PathVariable String id) {
        profileRepository.deleteById(id);
    }
}
