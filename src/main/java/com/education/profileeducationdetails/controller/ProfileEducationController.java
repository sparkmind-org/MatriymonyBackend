package com.education.profileeducationdetails.controller;



import com.education.profileeducationdetails.enities.ProfileEducation;
import com.education.profileeducationdetails.services.ProfileServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfileEducationController {


    @Autowired
    ProfileServices services;

    @PostMapping("/add")
      public ProfileEducation addRecord(@RequestBody ProfileEducation profile){
          return services.addRecord(profile);
      }

      @GetMapping("/getAll")
      public List<ProfileEducation> getAllRecords(){
        return services.getAll();
      }

    @GetMapping("/{id}")
    public ProfileEducation getProfileById(@PathVariable  Long id) {
        return services.getProfileId(id);
    }

    @PutMapping("/{id}")
    public ProfileEducation updateProfile(@PathVariable Long id, @RequestBody  ProfileEducation profile) {
        return services.updateProfile(id, profile);
    }
    @DeleteMapping("/{id}")
    public void deleteProfile(@PathVariable Long id) {
        services.deleteProfile(id);
    }


}
