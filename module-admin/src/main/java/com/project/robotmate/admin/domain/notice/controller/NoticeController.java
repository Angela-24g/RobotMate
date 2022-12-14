package com.project.robotmate.admin.domain.notice.controller;

import com.project.robotmate.admin.domain.notice.dto.response.NoticeResponse;
import com.project.robotmate.admin.domain.notice.service.NoticeService;
import com.project.robotmate.domain.common.dto.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping("/notices")
    public String viewNotices(
            Model model,
            @RequestParam(value = "page", defaultValue = "1") int page
    ) {
        Page<List<NoticeResponse>> notices = noticeService.getNotices(page);

        System.out.println("notices = " + notices);
        model.addAttribute("pageable", notices.getPageable());
        model.addAttribute("notices", notices.getContents());

        return "notice/list";
    }
}
