package com.example.MatrimonyApplication.controller;

import com.example.MatrimonyApplication.entity.FamilyDetails;
import com.example.MatrimonyApplication.entity.Profile;
import com.example.MatrimonyApplication.repository.FamilyDetailsRepository;
import com.example.MatrimonyApplication.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/familyDetails")
public class FamilyDetailsController {

    @Autowired
    private FamilyDetailsRepository familyDetailsRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @PostMapping("/{profileId}")
    public FamilyDetails addFamilyDetails(@PathVariable String profileId, @RequestBody FamilyDetails familyDetails) {
        Profile profile = profileRepository.findById(profileId).orElseThrow(() -> new RuntimeException("Profile not found"));
        familyDetails.setProfile(profile);
        return familyDetailsRepository.save(familyDetails);
    }

    @GetMapping("/{profileId}")
    public List<FamilyDetails> getFamilyDetails(@PathVariable String profileId) {
        Profile profile = profileRepository.findById(profileId).orElseThrow(() -> new RuntimeException("Profile not found"));
        return familyDetailsRepository.findByProfile(profile);
    }

    @PutMapping("/{profileId}/{familyDetailsId}")
    public FamilyDetails updateFamilyDetails(@PathVariable String profileId, @PathVariable Long familyDetailsId, @RequestBody FamilyDetails updatedFamilyDetails) {
        FamilyDetails familyDetails = familyDetailsRepository.findById(familyDetailsId).orElseThrow(() -> new RuntimeException("FamilyDetails not found"));
        Profile profile = profileRepository.findById(profileId).orElseThrow(() -> new RuntimeException("Profile not found"));
        familyDetails.setProfile(profile);
        familyDetails.setFathersName(updatedFamilyDetails.getFathersName());
        familyDetails.setMothersName(updatedFamilyDetails.getMothersName());
        familyDetails.setBrother(updatedFamilyDetails.getBrother());
        familyDetails.setSister(updatedFamilyDetails.getSister());
        familyDetails.setMarriedBrother(updatedFamilyDetails.getMarriedBrother());
        familyDetails.setMarriedSister(updatedFamilyDetails.getMarriedSister());
        familyDetails.setFathersOccupation(updatedFamilyDetails.getFathersOccupation());
        familyDetails.setMothersOccupation(updatedFamilyDetails.getMothersOccupation());
        familyDetails.setFamilyLocation(updatedFamilyDetails.getFamilyLocation());
        familyDetails.setFamilyIncome(updatedFamilyDetails.getFamilyIncome());
        familyDetails.setFamilyInfo(updatedFamilyDetails.getFamilyInfo());
        return familyDetailsRepository.save(familyDetails);
    }

    @DeleteMapping("/{profileId}/{familyDetailsId}")
    public void deleteFamilyDetails(@PathVariable String profileId, @PathVariable Long familyDetailsId) {
        FamilyDetails familyDetails = familyDetailsRepository.findById(familyDetailsId).orElseThrow(() -> new RuntimeException("FamilyDetails not found"));
        familyDetailsRepository.delete(familyDetails);
    }
}
