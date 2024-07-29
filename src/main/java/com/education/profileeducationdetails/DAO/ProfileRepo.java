package com.education.profileeducationdetails.DAO;

import com.education.profileeducationdetails.enities.ProfileEducation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepo extends JpaRepository<ProfileEducation, Long> {

    @Query("Select e from ProfileEducation e")
    public List<ProfileEducation> getAll();
}
