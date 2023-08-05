package com.project.robotmate.home.domain.faq.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequiredArgsConstructor
public class FaqController {

    // faq 페이지 열기
    @RequestMapping(value = "/faq", method = RequestMethod.GET)
    public String faq() {
        return "faq";
    }
}
