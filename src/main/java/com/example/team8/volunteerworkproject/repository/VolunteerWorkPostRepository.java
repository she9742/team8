package com.example.team8.volunteerworkproject.repository;

import com.example.team8.volunteerworkproject.entity.VolunteerWorkPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VolunteerWorkPostRepository extends JpaRepository<VolunteerWorkPost, Long> {
    Optional<VolunteerWorkPost> findByPostId(Long postId);
    Optional<VolunteerWorkPost> findByPostIdAndUserId(Long postId, String userId);
    List<VolunteerWorkPost> findAllByOrderByCreatedAtDesc();
}
