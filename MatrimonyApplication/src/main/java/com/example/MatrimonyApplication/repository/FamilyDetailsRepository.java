package com.example.MatrimonyApplication.repository;

import com.example.MatrimonyApplication.entity.FamilyDetails;
import com.example.MatrimonyApplication.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamilyDetailsRepository extends JpaRepository<FamilyDetails, Long> {
    List<FamilyDetails> findByProfile(Profile profile);
}
