package com.project.robotmate.admin.domain.gallery.service;

import com.project.robotmate.admin.domain.gallery.dto.request.GalleryRequest;
import com.project.robotmate.admin.domain.gallery.dto.request.GalleryUpdateRequest;
import com.project.robotmate.admin.domain.gallery.dto.response.GalleryResponse;
import com.project.robotmate.domain.common.dto.Page;
import com.project.robotmate.domain.common.dto.Searchable;
import com.project.robotmate.domain.entity.admin.Admin;

import java.util.List;

public interface GalleryService {

    GalleryResponse getGallery(Long id);

    Long save(GalleryRequest request, Admin admin);

    void update(Long id, GalleryUpdateRequest request);

    Page<List<GalleryResponse>> getGalleries(int page);

    Page<List<GalleryResponse>> getGalleries(Searchable searchable);
}
