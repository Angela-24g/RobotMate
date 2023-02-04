package com.project.robotmate.home.domain.gallery.controller;

import com.project.robotmate.domain.common.dto.Page;
import com.project.robotmate.domain.common.dto.Searchable;
import com.project.robotmate.home.domain.gallery.dto.response.GalleryResponse;
import com.project.robotmate.home.domain.gallery.service.GalleryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class GalleryController {

    private final GalleryService galleryService;

    @GetMapping("/gallery")
    public void viewGalleries(
            Model model,
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "year", required = false) String year
    ) {
        Searchable searchable = Searchable.builder()
                .page(page)
                .year(year).build();
        Page<List<GalleryResponse>> galleries = galleryService.getGalleries(searchable);
        model.addAttribute("pageable", galleries.getPageable());
        model.addAttribute("galleries", galleries.getContents());
    }

    // 갤러리 페이지 열기
    @RequestMapping(value="/galleryPage", method = RequestMethod.GET)
    public String gallery() {return "gallery"; }
}
