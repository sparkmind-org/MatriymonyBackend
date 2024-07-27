package com.example.MatrimonyApplication.repository;

import com.example.MatrimonyApplication.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProfileRepository extends JpaRepository<Profile, String> {

}