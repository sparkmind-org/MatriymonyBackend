package com.example.MatrimonyApplication.repository;

import com.example.MatrimonyApplication.entity.ProfileInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileInfoRepository extends JpaRepository<ProfileInfo, Long> {

}
