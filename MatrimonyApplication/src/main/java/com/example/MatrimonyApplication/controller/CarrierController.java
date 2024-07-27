package com.example.MatrimonyApplication.controller;

import com.example.MatrimonyApplication.entity.Carrier;
import com.example.MatrimonyApplication.entity.Profile;
import com.example.MatrimonyApplication.repository.CarrierRepository;
import com.example.MatrimonyApplication.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("customCarrierController")
@RequestMapping("/carriers")
public class CarrierController {

    @Autowired
    private CarrierRepository carrierRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @PostMapping("/{profileId}")
    public Carrier addCarrier(@PathVariable String profileId, @RequestBody Carrier carrier) {
        Profile profile = profileRepository.findById(profileId).orElseThrow(() -> new RuntimeException("Profile not found"));
        carrier.setProfile(profile);
        return carrierRepository.save(carrier);
    }

    @GetMapping("/{profileId}")
    public List<Carrier> getCarrier(@PathVariable String profileId) {
        Profile profile = profileRepository.findById(profileId).orElseThrow(() -> new RuntimeException("Profile not found"));
        return carrierRepository.findByProfile(profile);
    }

    @PutMapping("/{profileId}/{carrierId}")
    public Carrier updateCarrier(@PathVariable String profileId, @PathVariable Long carrierId, @RequestBody Carrier updatedCarrier) {
        Carrier carrier = carrierRepository.findById(carrierId).orElseThrow(() -> new RuntimeException("Carrier not found"));
        Profile profile = profileRepository.findById(profileId).orElseThrow(() -> new RuntimeException("Profile not found"));
        carrier.setProfile(profile);
        carrier.setEarnings(updatedCarrier.getEarnings());
        carrier.setEmployedIn(updatedCarrier.getEmployedIn());
        carrier.setOrganizationName(updatedCarrier.getOrganizationName());
        carrier.setOccupation(updatedCarrier.getOccupation());
        return carrierRepository.save(carrier);
    }

    @DeleteMapping("/{profileId}/{carrierId}")
    public void deleteCarrier(@PathVariable String profileId, @PathVariable Long carrierId) {
        Carrier carrier = carrierRepository.findById(carrierId).orElseThrow(() -> new RuntimeException("Carrier not found"));
        carrierRepository.delete(carrier);
    }
}
