package com.example.MatrimonyApplication.repository;

import com.example.MatrimonyApplication.entity.ProfileMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface ProfileMatchRepository extends JpaRepository<ProfileMatch, Long> {
    List<ProfileMatch> findByProfile_ProfileId(@Param("profileId") String profileId);

    Optional<ProfileMatch> findByProfile_ProfileIdAndMatchedProfileId(@Param("profileId") String profileId, @Param("matchedProfileId") String matchedProfileId);
}
