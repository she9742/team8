package com.example.team8.volunteerworkproject.repository;


import com.example.team8.volunteerworkproject.entity.Enrollment;
import com.example.team8.volunteerworkproject.enums.EnrollmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, String> {
    Optional<Enrollment> findByEnrollmentId(Long enrollmentId);
    List<Enrollment> findAllByUserIdAndEnrollmentStatusOrderByCreatedAtDesc(String userId, EnrollmentStatus status);
    List<Enrollment> findByUserIdAndPost_PostId(String userId, Long postId);
    List<Enrollment> findAllByPost_PostIdOrderByCreatedAtDesc(Long postId);
    List<Enrollment> findAllByOrderByCreatedAtDesc();
}

