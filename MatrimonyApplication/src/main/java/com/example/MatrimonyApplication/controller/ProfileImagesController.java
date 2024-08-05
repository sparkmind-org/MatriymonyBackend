package com.example.MatrimonyApplication.controller;

import com.example.MatrimonyApplication.entity.ProfileImages;
import com.example.MatrimonyApplication.service.ProfileImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/profileImages")
public class ProfileImagesController {

    @Autowired
    private ProfileImagesService service;

    @PostMapping("/upload/{profileId}")
    public ResponseEntity<?> uploadImage(@PathVariable String profileId, @RequestParam("image") MultipartFile file) {
        try {
            ProfileImages savedImage = service.uploadOrUpdateProfileImage(profileId, file);
            return ResponseEntity.ok(savedImage);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to upload image: " + e.getMessage());
        }
    }

    @GetMapping("/retrieve/{profileId}")
    public ResponseEntity<?> getImage(@PathVariable String profileId) {
        ProfileImages image = service.retrieveProfileImage(profileId);
        return image != null ? ResponseEntity.ok(image) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/remove/{profileId}")
    public ResponseEntity<?> removeImage(@PathVariable String profileId) {
        service.removeProfileImage(profileId);
        return ResponseEntity.noContent().build();
    }
}
