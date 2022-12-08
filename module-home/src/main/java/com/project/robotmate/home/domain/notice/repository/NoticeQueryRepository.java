package com.project.robotmate.home.domain.notice.repository;

import com.project.robotmate.domain.entity.Notice;
import com.project.robotmate.home.global.dto.response.Pageable;

import java.util.List;

public interface NoticeQueryRepository {
    List<Notice> findAll(Pageable pageable);

    Long countAll();
}
