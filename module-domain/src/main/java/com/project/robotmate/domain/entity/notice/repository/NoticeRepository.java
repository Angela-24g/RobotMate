package com.project.robotmate.domain.entity.notice.repository;

import com.project.robotmate.domain.entity.gallery.Gallery;
import com.project.robotmate.domain.entity.notice.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

    @Query("SELECT g FROM Gallery g WHERE g.id = :id AND g.delYn = 'N'")
    Optional<Notice> findById(@Param("id") Long id);





}
