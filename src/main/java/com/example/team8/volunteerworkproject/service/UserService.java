package com.example.team8.volunteerworkproject.service;

import com.example.team8.volunteerworkproject.dto.request.PwcheckRequestDto;
import com.example.team8.volunteerworkproject.dto.request.SigninRequestDto;
import com.example.team8.volunteerworkproject.dto.request.SignupRequestDto;
import com.example.team8.volunteerworkproject.jwt.AuthenticatedUserInfoDto;
import jakarta.servlet.http.HttpServletRequest;

public interface UserService {

  void signup(SignupRequestDto requestDto);
  AuthenticatedUserInfoDto signin(SigninRequestDto requestDto);

  void signout(HttpServletRequest request);

  void unregister(String userId, PwcheckRequestDto requestDto);


}
