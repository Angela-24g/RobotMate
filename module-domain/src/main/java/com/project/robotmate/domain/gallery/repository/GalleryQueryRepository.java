package com.project.robotmate.domain.gallery.repository;

import com.project.robotmate.domain.common.dto.Pageable;
import com.project.robotmate.domain.common.dto.Searchable;
import com.project.robotmate.domain.entity.Gallery;

import java.util.List;

public interface GalleryQueryRepository {

    List<Gallery> findAll(Pageable pageable);

    Long countAll();

    List<Gallery> findAllBySearchable(Pageable pageable, Searchable searchable);

    Long countAllBySearchable(Searchable searchable);
}
