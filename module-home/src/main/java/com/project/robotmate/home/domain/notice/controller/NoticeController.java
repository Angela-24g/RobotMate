package com.project.robotmate.home.domain.notice.controller;

import com.project.robotmate.home.domain.notice.dto.response.NoticeResponse;
import com.project.robotmate.home.domain.notice.service.NoticeService;
import com.project.robotmate.home.global.dto.response.DataResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @RequestMapping(value="/notice", method = RequestMethod.GET)
    public String notice() {return "notice"; }

    @RequestMapping("/notice/noticeList")
    @ResponseBody
    public ResponseEntity<DataResponse<List<NoticeResponse>>> noticeList(){
        List<NoticeResponse> noticeList = noticeService.getNoticeList();
        return ResponseEntity.ok(new DataResponse<>(noticeList));
    }


}
