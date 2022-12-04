package com.project.robotmate.domain.repository.gallery;

import com.project.robotmate.domain.entity.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface GalleryRepository extends JpaRepository<Gallery, Long> {

    @Query("SELECT g FROM Gallery g WHERE g.delYn = 'N'")
    List<Gallery> findAll();

    @Query("SELECT g FROM Gallery g WHERE g.id = :id AND g.delYn = 'N'")
    Optional<Gallery> findById(@Param("id") Long id);
}
