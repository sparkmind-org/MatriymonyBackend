package com.education.profileeducationdetails.services;


import com.education.profileeducationdetails.DAO.ProfileRepo;
import com.education.profileeducationdetails.enities.ProfileEducation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServices {

    @Autowired
    ProfileRepo repo;

    public ProfileEducation addRecord(ProfileEducation profile){
        return repo.save(profile);
    }

    public List<ProfileEducation> getAll(){
        return repo.findAll();
    }


    public ProfileEducation getProfileId(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("profile not found"));
    }

    public ProfileEducation updateProfile(Long id, ProfileEducation profile) {
        ProfileEducation profile1 =  getProfileId(id);
        profile1.setProfileId(profile.getProfileId());
        profile1.setSchool(profile.getSchool());
        profile1.setGraduation(profile.getGraduation());
        profile1.setPostGraduation(profile.getPostGraduation());

        return repo.save(profile1);
    }

    public void deleteProfile(Long id) {
        repo.deleteById(id);
    }




}
