package com.project.robotmate.admin.domain.gallery.controller;

import com.project.robotmate.admin.domain.gallery.dto.request.GalleryRequest;
import com.project.robotmate.admin.domain.gallery.dto.request.GalleryUpdateRequest;
import com.project.robotmate.admin.domain.gallery.service.GalleryService;
import com.project.robotmate.admin.global.dto.response.ApiResponse;
import com.project.robotmate.admin.global.dto.response.DataResponse;
import com.project.robotmate.domain.entity.admin.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class GalleryApiController {

    private final GalleryService galleryService;

    @PostMapping(value = "/api/galleries", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<DataResponse<Long>> createGallery(
            @ModelAttribute GalleryRequest request,
            Admin admin
    ) {
        Long galleryId = galleryService.save(request, admin);
        return ResponseEntity.ok(new DataResponse<>(galleryId));
    }

    @PutMapping(value = "/api/galleries/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse> editGallery(
            @ModelAttribute GalleryUpdateRequest request,
            @PathVariable("id") Long id
    ) {
        galleryService.update(id, request);
        return ResponseEntity.ok(ApiResponse.ok());
    }

    @DeleteMapping(value = "/api/galleries/{id}")
    public ResponseEntity<ApiResponse> editGallery(
            @PathVariable("id") Long id
    ) {
        galleryService.delete(id);
        return ResponseEntity.ok(ApiResponse.ok());
    }
}
