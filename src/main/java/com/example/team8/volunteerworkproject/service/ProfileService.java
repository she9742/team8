package com.example.team8.volunteerworkproject.service;


import com.example.team8.volunteerworkproject.dto.request.ProfileRequestDto;
import com.example.team8.volunteerworkproject.dto.response.ProfileResponseDto;

public interface ProfileService {

//  ProfileResponseDto createProfile(String userId, ProfileRequestDto requestDto);

  ProfileResponseDto getCustomerProfile(String userId);
  String getProfileImage(String userId);
  ProfileResponseDto updateProfile(String userId, ProfileRequestDto requestDto, String imgPath);




}

