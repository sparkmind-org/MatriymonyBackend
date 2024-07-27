package com.example.MatrimonyApplication.repository;

import com.example.MatrimonyApplication.entity.Lifestyle;
import com.example.MatrimonyApplication.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LifestyleRepository extends JpaRepository<Lifestyle, Long> {
    List<Lifestyle> findByProfile(Profile profile);
}
