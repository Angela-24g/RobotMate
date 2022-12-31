package com.project.robotmate.domain.entity.file.repository;

import com.project.robotmate.core.types.TargetType;
import com.project.robotmate.domain.entity.file.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FileRepository extends JpaRepository<File, Long> {

    @Query("SELECT f FROM File f WHERE f.targetId = :targetId AND f.type = :type AND f.delYn = 'N'")
    List<File> findAllByTargetIdAndType(@Param("targetId") Long targetId, @Param("type")TargetType type);


    @Query("SELECT f FROM File f WHERE f.targetId = :targetId AND f.type = :type AND f.delYn = 'N' AND f.displayOrder = 1")
    Optional<File> findByTargetIdAndType(@Param("targetId") Long targetId, @Param("type")TargetType type);
};
