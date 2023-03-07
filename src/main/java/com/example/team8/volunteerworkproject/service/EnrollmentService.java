package com.example.team8.volunteerworkproject.service;


import com.example.team8.volunteerworkproject.dto.request.EnrollmentRequestDto;
import com.example.team8.volunteerworkproject.dto.response.EnrollmentResponseDto;

import java.util.List;

public interface EnrollmentService {

/*
    void participation(Long postId, String userId);
*/
    //참가 신청
    EnrollmentResponseDto attend(Long postId, EnrollmentRequestDto requestDto, String userId);

    //참가 신청 취소(삭제)
    void cancel(Long postId, String userId, Long enrollmentId);

    List<EnrollmentResponseDto> getAllMyEnrollments(String userId);

    //참여 신청 내역 조회
    List<EnrollmentResponseDto> getEnrollmentList(Long postId);
}
