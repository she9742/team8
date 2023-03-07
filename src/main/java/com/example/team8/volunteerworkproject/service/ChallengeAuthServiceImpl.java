package com.example.team8.volunteerworkproject.service;

import com.example.team8.volunteerworkproject.dto.request.ChallengeAuthRequestDto;
import com.example.team8.volunteerworkproject.dto.response.AllChallengeAuthResponseDto;
import com.example.team8.volunteerworkproject.dto.response.ChallengeAuthResponseDto;
import com.example.team8.volunteerworkproject.entity.ChallengeAuth;
import com.example.team8.volunteerworkproject.entity.ChallengeAuthComment;
import com.example.team8.volunteerworkproject.repository.ChallengeAuthCommentRepository;
import com.example.team8.volunteerworkproject.repository.ChallengeAuthRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ChallengeAuthServiceImpl implements ChallengeAuthService {

  private final ChallengeAuthRepository challengeAuthRepository;
  private final ChallengeAuthCommentRepository challengeAuthCommentRepository;
  private final ChallengeAuthLikeServiceImpl challengeAuthLikeService;
  public static final String CLOUD_FRONT_DOMAIN_NAME = "d261u93iebql1x.cloudfront.net/";

  //챌린지 자랑 동록
  @Override
  public ChallengeAuthResponseDto createChallengeAuth(ChallengeAuthRequestDto requestDto,
                                                      String imgPath, String userId) {
    ChallengeAuth challengeAuth = new ChallengeAuth(userId, requestDto.getTitle(),
        requestDto.getContent(), CLOUD_FRONT_DOMAIN_NAME+imgPath);
    ChallengeAuth savedChallengeAuth = challengeAuthRepository.save(challengeAuth);
    return new ChallengeAuthResponseDto(savedChallengeAuth);
  }

  //챌린지 자랑 삭제
  @Override
  public void deleteChallengeAuth(Long challengeAuthId, String userId) {
    ChallengeAuth challengeAuth = challengeAuthRepository.findByChallengeAuthIdAndUserId(
        challengeAuthId, userId).orElseThrow(
        () -> new IllegalArgumentException("삭제할 챌린지 인증이 존재하지 않습니다."));
    challengeAuthRepository.delete(challengeAuth);

  }

  //챌린지 자랑 전체 조회
  @Override
  @Transactional(readOnly = true)
  public List<AllChallengeAuthResponseDto> getAllChallengeAuth() {
    List<ChallengeAuth> challengeAuths = challengeAuthRepository.findAll();
    List<AllChallengeAuthResponseDto> responseDtos = new ArrayList<>();
    for (ChallengeAuth challengeAuth : challengeAuths) {
      responseDtos.add(new AllChallengeAuthResponseDto(challengeAuth));
    }
    return responseDtos;
  }

  //챌린지 자랑 선택 조회
  @Override
  @Transactional(readOnly = true)
  public ChallengeAuthResponseDto getCahllengeAuth(Long challengeAuthId) {
    ChallengeAuth challengeAuth = challengeAuthRepository.findByChallengeAuthId(challengeAuthId)
        .orElseThrow(
            () -> new IllegalArgumentException("찾으시는 챌린지 인증글이 없습니다.")
        );
    List<ChallengeAuthComment> comments = challengeAuthCommentRepository.findAllByChallengeAuth(
        challengeAuth);
    int likeNum = challengeAuthLikeService.count(challengeAuthId);
    ChallengeAuthResponseDto responseDto = new ChallengeAuthResponseDto(challengeAuth, likeNum,
        comments);
    return responseDto;
  }

  //나의 챌린지 조회
  @Override
  public List<AllChallengeAuthResponseDto> getAllChallengeMyAuth(String userId) {
    List<ChallengeAuth> challengeAuths = challengeAuthRepository.findAllByUserId(userId);
    List<AllChallengeAuthResponseDto> responseDtos = new ArrayList<>();
    for (ChallengeAuth challengeAuth : challengeAuths) {
      responseDtos.add(new AllChallengeAuthResponseDto(challengeAuth));
    }
    return responseDtos;
  }

  //챌린지 인증 수정
  @Override
  public ChallengeAuthResponseDto updateChallengeAuth(Long challengeAuthId,
      ChallengeAuthRequestDto requestDto, String imgPath, String userId) {
    ChallengeAuth challengeAuth = challengeAuthRepository.findByChallengeAuthIdAndUserId(
        challengeAuthId, userId).orElseThrow(
        () -> new IllegalArgumentException("해당 챌린지 인증이 없거나, 본인의 챌린지 인증이 아닙니다.")
    );
    challengeAuth.update(requestDto.getTitle(), requestDto.getContent(), CLOUD_FRONT_DOMAIN_NAME+imgPath);
    ChallengeAuth savedChallengeAuth = challengeAuthRepository.save(challengeAuth);
    return new ChallengeAuthResponseDto(savedChallengeAuth);
  }

  @Override
  public String getchallengeAuthImage(String userId, Long challengeAuthId) {
    ChallengeAuth challengeAuth = challengeAuthRepository.findByChallengeAuthIdAndUserId(
        challengeAuthId, userId).orElseThrow(
        () -> new IllegalArgumentException("해당 챌린지 인증이 없거나, 본인의 챌린지 인증이 아닙니다.")
    );
    return challengeAuth.getImage().substring(30);
  }
}
