package com.example.team8.volunteerworkproject.repository;

import java.util.Optional;

import com.example.team8.volunteerworkproject.entity.User;
import com.example.team8.volunteerworkproject.security.UserDetailsImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
  Optional<User> findByUserId(String userId);
  Optional<User> findByCompanyRegisterNumb(String companyRegisterNumb);

    Optional<Object> findByUserId(UserDetailsImpl userDetails);
}
