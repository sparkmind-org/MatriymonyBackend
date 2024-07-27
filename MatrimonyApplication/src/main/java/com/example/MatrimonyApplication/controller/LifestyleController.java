package com.example.MatrimonyApplication.controller;

import com.example.MatrimonyApplication.entity.Lifestyle;
import com.example.MatrimonyApplication.entity.Profile;
import com.example.MatrimonyApplication.repository.LifestyleRepository;
import com.example.MatrimonyApplication.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lifestyle")
public class LifestyleController {

    @Autowired
    private LifestyleRepository lifestyleRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @PostMapping("/{profileId}")
    public Lifestyle addLifestyle(@PathVariable String profileId, @RequestBody Lifestyle lifestyle) {
        Profile profile = profileRepository.findById(profileId).orElseThrow(() -> new RuntimeException("Profile not found"));
        lifestyle.setProfile(profile);
        return lifestyleRepository.save(lifestyle);
    }

    @GetMapping("/{profileId}")
    public List<Lifestyle> getLifestyle(@PathVariable String profileId) {
        Profile profile = profileRepository.findById(profileId).orElseThrow(() -> new RuntimeException("Profile not found"));
        return lifestyleRepository.findByProfile(profile);
    }

    @PutMapping("/{profileId}/{lifestyleId}")
    public Lifestyle updateLifestyle(@PathVariable String profileId, @PathVariable Long lifestyleId, @RequestBody Lifestyle updatedLifestyle) {
        Lifestyle lifestyle = lifestyleRepository.findById(lifestyleId).orElseThrow(() -> new RuntimeException("Lifestyle not found"));
        Profile profile = profileRepository.findById(profileId).orElseThrow(() -> new RuntimeException("Profile not found"));
        lifestyle.setProfile(profile);
        lifestyle.setDiet(updatedLifestyle.getDiet());
        lifestyle.setDrink(updatedLifestyle.getDrink());
        lifestyle.setLanguageInterest(updatedLifestyle.getLanguageInterest());
        lifestyle.setOpenToPets(updatedLifestyle.getOpenToPets());
        lifestyle.setSmoking(updatedLifestyle.getSmoking());
        return lifestyleRepository.save(lifestyle);
    }

    @DeleteMapping("/{profileId}/{lifestyleId}")
    public void deleteLifestyle(@PathVariable String profileId, @PathVariable Long lifestyleId) {
        Lifestyle lifestyle = lifestyleRepository.findById(lifestyleId).orElseThrow(() -> new RuntimeException("Lifestyle not found"));
        lifestyleRepository.delete(lifestyle);
    }
}
