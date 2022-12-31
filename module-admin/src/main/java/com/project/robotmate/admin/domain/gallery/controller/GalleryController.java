package com.project.robotmate.admin.domain.gallery.controller;

import com.project.robotmate.admin.domain.gallery.dto.response.GalleryResponse;
import com.project.robotmate.admin.domain.gallery.service.GalleryService;
import com.project.robotmate.admin.global.util.DateUtil;
import com.project.robotmate.domain.common.dto.Page;
import com.project.robotmate.domain.common.dto.Searchable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class GalleryController {

   private final GalleryService galleryService;
    @GetMapping(value = "/galleries")
    public String viewGalleries(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "year", required = false) String year,
            @RequestParam(value = "type", required = false) String type,
            Model model
    ){
        Searchable searchable = new Searchable(page, type, year);
        Page<List<GalleryResponse>> galleries = galleryService.getGalleries(searchable);

        model.addAttribute("pageable", galleries.getPageable());
        model.addAttribute("galleries", galleries.getContents());
        model.addAttribute("years", DateUtil.getYears());

        return "gallery/list";
    }

    @GetMapping(value = "/galleries/edit")
    public String viewGalleriesEdit() {
        return "gallery/edit";
    }

    @GetMapping(value = "/galleries/edit/{id}")
    public String viewGalleriesEdit(
            @PathVariable("id") Long id,
            Model model
    ) {
        GalleryResponse gallery = galleryService.getGallery(id);
        model.addAttribute("gallery", gallery);
        return "gallery/edit";
    }

    @GetMapping(value = "/galleries/{id}")
    public String viewGalleries(
            @PathVariable("id") Long id,
            Model model
    ) {
        GalleryResponse gallery = galleryService.getGallery(id);
        model.addAttribute("gallery", gallery);
        return "gallery/detail";
    }

}
