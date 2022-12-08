package com.project.robotmate.home.domain.notice.service;

import com.project.robotmate.home.domain.notice.dto.response.NoticeResponse;
import com.project.robotmate.home.global.dto.response.Page;

import java.util.List;

public interface NoticeService {

    Page<List<NoticeResponse>> getNotices(int page);
}
