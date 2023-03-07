package com.example.team8.volunteerworkproject.service;

public interface VolunteerWorkPostLikeService {

    void update(Long postId, String userId);

    int count(Long postId);

}
