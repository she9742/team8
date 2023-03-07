package com.example.team8.volunteerworkproject.service;


import com.example.team8.volunteerworkproject.dto.request.NoticeRequestDto;
import com.example.team8.volunteerworkproject.dto.response.CommentCautionResponseDto;
import com.example.team8.volunteerworkproject.dto.response.NoticeResponseDto;

import java.util.List;


public interface AdminService {

  NoticeResponseDto createNotice(NoticeRequestDto requestDto);

  List<NoticeResponseDto> getNoticeList();

  NoticeResponseDto findNotice(Long noticeId);

  NoticeResponseDto updateNotice(Long noticeId, NoticeRequestDto requestDto);

  void deleteNotice(Long noticeId);

  void adminDeletePost(Long postId);

  void adminDeleteComment(Long postId, Long commentId);

  void userBlock(String userId);

  void userNormal(String userId);

  List<CommentCautionResponseDto> getCautionUserList();


}
