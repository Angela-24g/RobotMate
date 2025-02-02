package com.project.robotmate.home.domain.notice.controller;

import com.project.robotmate.domain.common.dto.Page;
import com.project.robotmate.domain.common.dto.Searchable;
import com.project.robotmate.home.domain.notice.dto.response.NoticeResponse;
import com.project.robotmate.home.domain.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@Slf4j
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

//    public NoticeController(NoticeService noticeService) {
//        this.noticeService = noticeService;
//    }


    // 공지사항 페이지 열기
    @GetMapping("/notice")
    public String notice(Model model,
                         @RequestParam(value = "page", defaultValue = "1") int page) {
        Searchable searchable = Searchable.builder()
                .page(page)
                .build();

        Page<List<NoticeResponse>> noticeList = noticeService.getNoticeList(searchable);
        model.addAttribute("noticeList", noticeList.getContents());
        model.addAttribute("pageable", noticeList.getPageable());

        return "notice"; }

//     공지사항 세부 페이지 열기
    @RequestMapping(value="/noticeDetail/{id}", method = RequestMethod.GET)
    public String noticeDetail(@PathVariable("id") Long id, Model model) {
        NoticeResponse n = noticeService.getNoticeDetail(id);
        model.addAttribute("notice", n);
        return "noticeDetail";
    }


}
