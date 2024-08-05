package com.example.MatrimonyApplication.service;

import com.example.MatrimonyApplication.entity.ProfileImages;
import com.example.MatrimonyApplication.repository.ProfileImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ProfileImagesService {

    @Autowired
    private ProfileImagesRepository repository;

    public ProfileImages uploadOrUpdateProfileImage(String profileId, MultipartFile file) throws IOException {
        ProfileImages image = repository.findByProfileId(profileId);
        if (image == null) {
            image = new ProfileImages();
            image.setProfileId(profileId);
        }
        image.setImage(file.getBytes());
        return repository.save(image);
    }

    public ProfileImages retrieveProfileImage(String profileId) {
        return repository.findByProfileId(profileId);
    }

    public void removeProfileImage(String profileId) {
        ProfileImages image = repository.findByProfileId(profileId);
        if (image != null) {
            repository.deleteById(image.getId());
        }
    }
}
