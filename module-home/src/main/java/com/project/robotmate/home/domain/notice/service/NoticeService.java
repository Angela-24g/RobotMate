package com.project.robotmate.home.domain.notice.service;

import com.project.robotmate.domain.common.dto.Page;
import com.project.robotmate.domain.common.dto.Searchable;
import com.project.robotmate.home.domain.notice.dto.response.NoticeResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface NoticeService {

    //Page<List<NoticeResponse>> getNotices(int page);

    // 공지사항 페이지 열기
    Page<List<NoticeResponse>> getNoticeList(Searchable searchable);
    List<NoticeResponse> getNoticeListDetail(HttpServletRequest req);

    // 공지사항 상세보기
    NoticeResponse getNoticeDetail(Long id);

}
