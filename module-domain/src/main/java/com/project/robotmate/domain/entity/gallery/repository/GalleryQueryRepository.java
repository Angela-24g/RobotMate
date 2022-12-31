package com.project.robotmate.domain.entity.gallery.repository;

import com.project.robotmate.domain.common.dto.Pageable;
import com.project.robotmate.domain.common.dto.Searchable;
import com.project.robotmate.domain.entity.gallery.Gallery;

import java.util.List;
import java.util.Optional;

public interface GalleryQueryRepository {

    Optional<Gallery> findById(Long id);

    List<Gallery> findAll(Pageable pageable);

    Long countAll();

    List<Gallery> findAllBySearchable(Pageable pageable, Searchable searchable);

    Long countAllBySearchable(Searchable searchable);
}
