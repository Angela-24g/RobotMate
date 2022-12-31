package com.project.robotmate.domain.entity.notice.repository;

import com.project.robotmate.domain.entity.notice.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
