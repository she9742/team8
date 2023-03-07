package com.example.team8.volunteerworkproject.repository;

import com.example.team8.volunteerworkproject.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProfileRepository extends JpaRepository<Profile, String> {
  Optional<Profile> findByUserId(String userId);

}
