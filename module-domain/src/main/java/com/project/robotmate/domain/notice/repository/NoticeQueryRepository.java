package com.project.robotmate.domain.notice.repository;

import com.project.robotmate.domain.common.dto.Pageable;
import com.project.robotmate.domain.entity.Notice;

import java.util.List;

public interface NoticeQueryRepository {
    List<Notice> findAll(Pageable pageable);

    Long countAll();
}
