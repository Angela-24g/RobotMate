package com.project.robotmate.home.domain.notice.controller;

import com.project.robotmate.home.domain.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class NoticeApiControlle {

    private final NoticeService noticeService;

//    @GetMapping("/api/notices")
//    @PostMapping("/api/notices")
//    @GetMapping("/api/notices/{id}")
//    @PutMapping("/api/notices/{id}")
//    @DeleteMapping("/api/notices/{id}")
}
