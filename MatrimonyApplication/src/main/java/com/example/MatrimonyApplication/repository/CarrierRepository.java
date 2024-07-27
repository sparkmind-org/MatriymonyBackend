package com.example.MatrimonyApplication.repository;

import com.example.MatrimonyApplication.entity.Carrier;
import com.example.MatrimonyApplication.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarrierRepository extends JpaRepository<Carrier, Long> {
    List<Carrier> findByProfile(Profile profile);
}
