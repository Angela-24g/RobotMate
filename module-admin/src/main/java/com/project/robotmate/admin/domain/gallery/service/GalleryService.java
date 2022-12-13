package com.project.robotmate.admin.domain.gallery.service;

import com.project.robotmate.admin.domain.gallery.dto.request.GalleryCreateRequest;
import com.project.robotmate.admin.domain.gallery.dto.response.GalleryResponse;
import com.project.robotmate.domain.common.dto.Page;
import com.project.robotmate.domain.common.dto.Searchable;
import com.project.robotmate.domain.entity.Admin;

import java.util.List;

public interface GalleryService {

    void save(GalleryCreateRequest request, Admin admin);

    Page<List<GalleryResponse>> getGalleries(int page);

    Page<List<GalleryResponse>> getGalleries(Searchable searchable);
}
