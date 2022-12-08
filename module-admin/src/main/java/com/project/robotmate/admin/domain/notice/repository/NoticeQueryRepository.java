package com.project.robotmate.admin.domain.notice.repository;

import com.project.robotmate.admin.global.dto.response.Pageable;
import com.project.robotmate.domain.entity.Notice;

import java.util.List;

public interface NoticeQueryRepository {
    List<Notice> findAll(Pageable pageable);

    Long countAll();
}
