package com.example.MatrimonyApplication.controller;

import com.example.MatrimonyApplication.entity.ProfileVisits;
import com.example.MatrimonyApplication.service.ProfileVisitsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profileVisits")
public class ProfileVisitsController {

    @Autowired
    private ProfileVisitsService profileVisitsService;

    @PostMapping
    public ResponseEntity<ProfileVisits> recordProfileVisit(@Valid @RequestBody ProfileVisits profileVisit) {
        if (profileVisit.getVisitToProfile() == null || profileVisit.getVisitFromProfile() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        ProfileVisits recordedVisit = profileVisitsService.recordProfileVisit(profileVisit.getVisitToProfile(), profileVisit.getVisitFromProfile());
        return new ResponseEntity<>(recordedVisit, HttpStatus.CREATED);
    }

    @GetMapping("/{profileId}")
    public ResponseEntity<List<ProfileVisits>> getAllProfileVisits(@PathVariable String profileId) {
        List<ProfileVisits> visits = profileVisitsService.getAllProfileVisits(profileId);
        if (visits.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(visits, HttpStatus.OK);
    }

    @GetMapping("/{profileId}/recent")
    public ResponseEntity<ProfileVisits> getRecentlyVisited(@PathVariable String profileId) {
        ProfileVisits visit = profileVisitsService.getMostRecentVisit(profileId);
        if (visit == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(visit, HttpStatus.OK);
    }
}
