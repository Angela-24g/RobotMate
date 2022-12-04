package com.project.robotmate.home.domain.gallery.repository;

import com.project.robotmate.domain.entity.Gallery;
import com.project.robotmate.home.global.dto.response.Pageable;
import com.project.robotmate.home.global.dto.response.Searchable;

import java.util.List;

public interface GalleryQueryRepository {

    List<Gallery> findAll(Pageable pageable);

    Long countAll();

    List<Gallery> findAllBySearchable(Pageable pageable, Searchable searchable);

    Long countAllBySearchable(Searchable searchable);
}
