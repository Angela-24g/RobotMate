package com.project.robotmate.domain.repository.notice;

import com.project.robotmate.domain.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
