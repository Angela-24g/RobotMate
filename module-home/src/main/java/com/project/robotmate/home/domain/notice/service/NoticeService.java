package com.project.robotmate.home.domain.notice.service;

import com.project.robotmate.domain.common.dto.Page;
import com.project.robotmate.domain.common.dto.Searchable;
import com.project.robotmate.home.domain.notice.dto.response.NoticeResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface NoticeService {

    //Page<List<NoticeResponse>> getNotices(int page);
    Page<List<NoticeResponse>> getNoticeList(Searchable searchable);
    List<NoticeResponse> getNoticeListDetail(HttpServletRequest req);
}
