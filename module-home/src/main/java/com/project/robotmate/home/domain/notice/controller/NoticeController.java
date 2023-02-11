package com.project.robotmate.home.domain.notice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequiredArgsConstructor
public class NoticeController {

    // 갤러리 페이지 열기
    @RequestMapping(value="/noticePage", method = RequestMethod.GET)
    public String notice() {return "notice"; }
}
