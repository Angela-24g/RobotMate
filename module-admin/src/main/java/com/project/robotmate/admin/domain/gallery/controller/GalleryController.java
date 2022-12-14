package com.project.robotmate.admin.domain.gallery.controller;

import cloud.aws.s3.S3UploadProvider;
import cloud.aws.s3.model.S3File;
import com.project.robotmate.admin.domain.gallery.dto.response.GalleryResponse;
import com.project.robotmate.admin.domain.gallery.service.GalleryService;
import com.project.robotmate.core.types.DirectoryType;
import com.project.robotmate.domain.common.dto.Page;
import com.project.robotmate.domain.common.dto.Searchable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class GalleryController {

   private final GalleryService galleryService;
   private final S3UploadProvider s3UploadProvider;
    @GetMapping(value = "/galleries")
    public String viewGalleries(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "year", required = false) String year,
            @RequestParam(value = "type", required = false) String type,
            Model model
    ) {
        Searchable searchable = new Searchable(page, type, year);
        Page<List<GalleryResponse>> galleries = galleryService.getGalleries(searchable);

        model.addAttribute("pageable", galleries.getPageable());
        model.addAttribute("galleries", galleries.getContents());
        return "gallery/list";
    }

    @PostMapping(value = "/test")
    public ResponseEntity<S3File> test(
            @RequestPart(value = "file")MultipartFile file
            ) {
        S3File upload = s3UploadProvider.upload(file, DirectoryType.GALLERY);
        System.out.println("upload = " + upload);
        return ResponseEntity.ok(upload);
    }
}
