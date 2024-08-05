package com.education.profileeducationdetails.controller;

import com.education.profileeducationdetails.enities.FavouriteRequest;
import com.education.profileeducationdetails.enities.FavouriteTracking;
import com.education.profileeducationdetails.services.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favourites")
public class FavouriteController {

    @Autowired
    private FavouriteService service;


    @PostMapping("/add")
    public ResponseEntity<?> addFavorite(@RequestBody FavouriteRequest favouriteRequest) {
        if (favouriteRequest == null || favouriteRequest.getSenderProfileId() == null || favouriteRequest.getReceiverProfileId() == null) {
            return ResponseEntity.badRequest().body("Missing senderProfileId or receiverProfileId");
        }

        try {
            FavouriteTracking savedFavourite = service.addFavourite(
                    favouriteRequest.getSenderProfileId(),
                    favouriteRequest.getReceiverProfileId()
            );
            return ResponseEntity.status(201).body(savedFavourite);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An unexpected error occurred.");
        }
    }
    @PostMapping("/remove")
    public ResponseEntity<?> removeFavorite(@RequestBody FavouriteRequest favouriteRequest) {
        if (favouriteRequest == null || favouriteRequest.getSenderProfileId() == null || favouriteRequest.getReceiverProfileId() == null) {
            return ResponseEntity.badRequest().body("Missing senderProfileId or receiverProfileId");
        }

        try {
            service.removeFavourite(favouriteRequest.getSenderProfileId(), favouriteRequest.getReceiverProfileId());
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An unexpected error occurred.");
        }
    }

    @GetMapping("/allFav/{profileId}")
    public ResponseEntity<List<FavouriteTracking>> getAllFavorites(@PathVariable String profileId) {
        if (profileId == null) {
            return ResponseEntity.badRequest().body(null);
        }

        List<FavouriteTracking> favourites = service.getAllFavourites(profileId);
        return ResponseEntity.ok(favourites);
    }
}