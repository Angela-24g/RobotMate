package com.project.robotmate.domain.entity.notice.repository;

import com.project.robotmate.domain.entity.gallery.Gallery;
import com.project.robotmate.domain.entity.notice.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

    @Query("SELECT g FROM Notice g WHERE g.delYn = 'N' AND g.publicYn = 'Y'")
    List<Notice> findAll();

    @Query("SELECT g FROM Notice g WHERE g.id = :id AND g.delYn = 'N' AND g.publicYn = 'Y'")
    Optional<Notice> findById(@Param("id") Long id);


}
