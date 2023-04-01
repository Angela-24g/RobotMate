package com.project.robotmate.home.domain.common.home.controller;

import com.project.robotmate.home.domain.gallery.dto.response.GalleryResponse;
import com.project.robotmate.home.domain.gallery.service.GalleryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final GalleryService galleryService;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String home(Model model) {
        List<GalleryResponse> galleries = galleryService.getTop6Awards();
        List<GalleryResponse> mainGalleries = galleryService.getMainGalleries();

        model.addAttribute("galleries", galleries);
        model.addAttribute("mainGalleries", mainGalleries);
        return "index";
    }

}
