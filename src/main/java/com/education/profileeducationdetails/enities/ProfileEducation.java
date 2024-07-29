package com.education.profileeducationdetails.enities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class ProfileEducation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String profileId;
    private String school;
    private String graduation;
    private String postGraduation;


    public ProfileEducation() {
    }

    public ProfileEducation(int id, String profileId, String school, String graduation, String postGraduation) {
        this.id = id;
        this.profileId = profileId;
        this.school = school;
        this.graduation = graduation;
        this.postGraduation = postGraduation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getGraduation() {
        return graduation;
    }

    public void setGraduation(String graduation) {
        this.graduation = graduation;
    }

    public String getPostGraduation() {
        return postGraduation;
    }

    public void setPostGraduation(String postGraduation) {
        this.postGraduation = postGraduation;
    }

    @Override
    public String toString() {
        return "ProfileEducation{" +
                "id=" + id +
                ", profileId='" + profileId + '\'' +
                ", school='" + school + '\'' +
                ", graduation='" + graduation + '\'' +
                ", postGraduation='" + postGraduation + '\'' +
                '}';
    }
}
