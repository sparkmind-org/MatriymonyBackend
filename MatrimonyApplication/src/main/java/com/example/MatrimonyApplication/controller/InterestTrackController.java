package com.example.MatrimonyApplication.controller;

import com.example.MatrimonyApplication.dto.InterestDTO;
import com.example.MatrimonyApplication.dto.ProfileInterestDTO;
import com.example.MatrimonyApplication.entity.InterestTrack;
import com.example.MatrimonyApplication.service.InterestTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interests")
public class InterestTrackController {

    @Autowired
    private InterestTrackService service;

    @PostMapping("/send")
    public ResponseEntity<?> sendInterest(@RequestBody InterestDTO interestDTO) {
        if (interestDTO.getReceiverProfileId().equals(interestDTO.getSenderProfileId())) {
            return ResponseEntity.badRequest().body("A profile cannot express interest in itself");
        }

        InterestTrack result = service.sendInterest(interestDTO.getReceiverProfileId(), interestDTO.getSenderProfileId());
        if (result == null) {
            return ResponseEntity.badRequest().body("Interest already exists between these profiles");
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/received/{receiverProfileId}")
    public List<InterestDTO> getInterests(@PathVariable String receiverProfileId) {
        return service.getInterests(receiverProfileId);
    }

    @GetMapping("/most")
    public ProfileInterestDTO mostInterested() {
        return service.mostInterested();
    }

    @GetMapping("/least")
    public ProfileInterestDTO leastInterested() {
        return service.leastInterested();
    }
}
