package com.example.team8.volunteerworkproject.service;


import com.example.team8.volunteerworkproject.dto.request.ChallengeAuthRequestDto;
import com.example.team8.volunteerworkproject.dto.response.AllChallengeAuthResponseDto;
import com.example.team8.volunteerworkproject.dto.response.ChallengeAuthResponseDto;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;


public interface ChallengeAuthService {

    ChallengeAuthResponseDto createChallengeAuth(ChallengeAuthRequestDto requestDto, String imgPath, String userId);
    void deleteChallengeAuth (@PathVariable Long challengeAuthId, String userId);
    List<AllChallengeAuthResponseDto> getAllChallengeAuth();
    ChallengeAuthResponseDto getCahllengeAuth(Long challengeAuthId);
    List<AllChallengeAuthResponseDto> getAllChallengeMyAuth(String userId);
    ChallengeAuthResponseDto updateChallengeAuth(@PathVariable Long challengeAuthId, ChallengeAuthRequestDto requestDto, String imgPath, String userId);
    String getchallengeAuthImage(String userId, Long challengeAuthId);


}
