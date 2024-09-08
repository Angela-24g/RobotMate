package com.project.robotmate.admin.domain.notice.service;

import com.project.robotmate.admin.domain.gallery.dto.request.GalleryUpdateRequest;
import com.project.robotmate.admin.domain.gallery.dto.response.GalleryResponse;
import com.project.robotmate.admin.domain.notice.dto.request.NoticeRequest;
import com.project.robotmate.admin.domain.notice.dto.request.NoticeUpdateRequest;
import com.project.robotmate.admin.domain.notice.dto.response.NoticeResponse;
import com.project.robotmate.domain.common.dto.Page;
import com.project.robotmate.domain.entity.admin.Admin;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface NoticeService {
    Long save(NoticeRequest request, Admin admin);

    Page<List<NoticeResponse>> getNotices(int page);

    NoticeResponse getNotice(Long id);

    String saveImg(MultipartFile file);

    void update(Long id, NoticeUpdateRequest request);

    void delete(Long id);
}
