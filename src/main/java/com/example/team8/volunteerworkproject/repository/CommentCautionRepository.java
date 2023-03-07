package com.example.team8.volunteerworkproject.repository;

import com.example.team8.volunteerworkproject.entity.CommentCaution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CommentCautionRepository extends JpaRepository<CommentCaution, Long> {


  @Override
  Optional<CommentCaution> findById(Long cautionId);

  List<CommentCaution> findAllByOrderByModifiedAtDesc();


}
