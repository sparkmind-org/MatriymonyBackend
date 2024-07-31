package com.example.MatrimonyApplication.controller;

import com.example.MatrimonyApplication.dto.ProfileMatchDTO;
import com.example.MatrimonyApplication.service.ProfileMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile-matches")
public class ProfileMatchController {

    @Autowired
    private ProfileMatchService profileMatchService;

    @GetMapping("/{profileId}")
    public List<ProfileMatchDTO> getMatchingProfiles(@PathVariable String profileId) {
        return profileMatchService.getMatchingProfiles(profileId);
    }
}
