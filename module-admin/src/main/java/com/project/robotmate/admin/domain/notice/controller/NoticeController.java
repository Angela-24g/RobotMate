package com.project.robotmate.admin.domain.notice.controller;

import com.project.robotmate.admin.domain.notice.dto.response.NoticeResponse;
import com.project.robotmate.admin.domain.notice.service.NoticeService;
import com.project.robotmate.domain.common.dto.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping(value = "/notices/edit")
    public String viewNoticeEdit() {
        return "notice/edit";
    }

    @GetMapping(value = "/notices/edit/{id}")
    public String viewNoticeEdit(
            @PathVariable("id") Long id,
            Model model
    ) {
        NoticeResponse notice = noticeService.getNotice(id);
        model.addAttribute("notice", notice);
        return "notice/edit";
    }




}
