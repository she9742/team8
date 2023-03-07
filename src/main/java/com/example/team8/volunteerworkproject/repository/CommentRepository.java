package com.example.team8.volunteerworkproject.repository;


import com.example.team8.volunteerworkproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

  @Override
  Optional<Comment> findById(Long commentId);

  Optional<Comment> findByUserId(String userId);

  Optional<List<Comment>> findByPostId(Long postId);


}
