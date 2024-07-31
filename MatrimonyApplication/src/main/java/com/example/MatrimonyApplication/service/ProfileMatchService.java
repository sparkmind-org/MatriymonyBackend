package com.example.MatrimonyApplication.service;

import com.example.MatrimonyApplication.dto.ProfileMatchDTO;
import com.example.MatrimonyApplication.entity.Profile;
import com.example.MatrimonyApplication.entity.ProfileInfo;
import com.example.MatrimonyApplication.entity.ProfileMatch;
import com.example.MatrimonyApplication.repository.ProfileInfoRepository;
import com.example.MatrimonyApplication.repository.ProfileMatchRepository;
import com.example.MatrimonyApplication.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileMatchService {

    @Autowired
    private ProfileMatchRepository profileMatchRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ProfileInfoRepository profileInfoRepository;

    public List<ProfileMatchDTO> getMatchingProfiles(String profileId) {
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
        ProfileInfo profileInfo = profile.getProfileInfo();

        List<ProfileInfo> allProfileInfos = profileInfoRepository.findAll();

        List<ProfileInfo> matchedProfileInfos = allProfileInfos.stream()
                .filter(pi -> !pi.getProfile().getProfileId().equals(profileId))
                .filter(pi -> pi.getCaste().equals(profileInfo.getCaste())
                        || pi.getEducation().equals(profileInfo.getEducation())
                        || pi.getProfession().equals(profileInfo.getProfession()))
                .collect(Collectors.toList());

        List<ProfileMatchDTO> profileMatchDTOs = matchedProfileInfos.stream()
                .map(pi -> new ProfileMatchDTO(profileId, pi.getProfile().getProfileId()))
                .collect(Collectors.toList());

        // Check for existing matches before saving new ones
        List<ProfileMatch> newMatches = matchedProfileInfos.stream()
                .filter(pi -> !profileMatchRepository
                        .findByProfile_ProfileIdAndMatchedProfileId(profileId, pi.getProfile().getProfileId())
                        .isPresent())
                .map(pi -> {
                    ProfileMatch profileMatch = new ProfileMatch();
                    profileMatch.setProfile(profile);
                    profileMatch.setMatchedProfileId(pi.getProfile().getProfileId());
                    return profileMatch;
                })
                .collect(Collectors.toList());

        profileMatchRepository.saveAll(newMatches);

        return profileMatchDTOs;
    }
}
