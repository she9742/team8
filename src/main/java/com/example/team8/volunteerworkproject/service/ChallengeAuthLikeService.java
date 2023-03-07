package com.example.team8.volunteerworkproject.service;

public interface ChallengeAuthLikeService {

    void update (Long challengeAuthId, String userId);
    int count(Long challengeAuthId);
}
