package com.project.robotmate.domain.entity.notice.repository;

import com.project.robotmate.domain.common.dto.Pageable;
import com.project.robotmate.domain.common.dto.Searchable;
import com.project.robotmate.domain.entity.notice.Notice;

import java.util.List;
import java.util.Optional;

public interface NoticeQueryRepository {
    List<Notice> findAll(Pageable pageable);

    Long countAll();

    Optional<Notice> findById(Long id);

    List<Notice> findAllBySearchable(Pageable pageable, Searchable searchable);

    Long countAllBySearchable(Searchable searchable);

}
