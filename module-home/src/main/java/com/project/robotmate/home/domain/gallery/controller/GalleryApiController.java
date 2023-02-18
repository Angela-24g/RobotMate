package com.project.robotmate.home.domain.gallery.controller;

import com.project.robotmate.domain.common.dto.Page;
import com.project.robotmate.domain.common.dto.Searchable;
import com.project.robotmate.home.domain.gallery.dto.response.GalleryResponse;
import com.project.robotmate.home.domain.gallery.service.GalleryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class GalleryApiController {

    private final GalleryService galleryService;

    @GetMapping("/api/galleries")
    public ResponseEntity<HashMap<String, Object>> viewGalleries(
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "year", required = false) String year
    ) {
        Searchable searchable = Searchable.builder()
                .page(page)
                .year(year).build();
        Page<List<GalleryResponse>> galleries = galleryService.getGalleries(searchable);

        HashMap<String, Object> result = new HashMap<>();
        result.put("galleries", galleries.getContents());
        return ResponseEntity.ok(result);
    }
}
