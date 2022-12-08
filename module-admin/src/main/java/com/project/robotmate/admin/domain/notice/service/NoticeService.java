package com.project.robotmate.admin.domain.notice.service;

import com.project.robotmate.admin.domain.notice.dto.request.NoticeRequest;
import com.project.robotmate.admin.domain.notice.dto.response.NoticeResponse;
import com.project.robotmate.admin.global.dto.response.Page;
import com.project.robotmate.domain.entity.Admin;

import java.util.List;

public interface NoticeService {
    void save(NoticeRequest request, Admin admin);

    Page<List<NoticeResponse>> getNotices(int page);
}
