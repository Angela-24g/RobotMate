package com.project.robotmate.home.domain.gallery.service;

import com.project.robotmate.home.domain.gallery.dto.response.GalleryResponse;
import com.project.robotmate.home.global.dto.response.Page;
import com.project.robotmate.home.global.dto.response.Searchable;

import java.util.List;

public interface GalleryService {

    /**
     * 해당 페이지의 모든 갤러리의 데이터를 반환합니다.
     * @param page 페이지
     * */
    Page<List<GalleryResponse>> getGalleries(int page);

    /**
     * 해당 조건의 모든 갤러리의 데이터를 반환합니다.
     * @param searchable 조건 객체
     * */
    Page<List<GalleryResponse>> getGalleries(Searchable searchable);
}
