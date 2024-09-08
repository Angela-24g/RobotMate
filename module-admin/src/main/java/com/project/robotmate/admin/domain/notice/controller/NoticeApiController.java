package com.project.robotmate.admin.domain.notice.controller;

import com.project.robotmate.admin.domain.notice.dto.request.NoticeRequest;
import com.project.robotmate.admin.domain.notice.dto.request.NoticeUpdateRequest;
import com.project.robotmate.admin.domain.notice.service.NoticeService;
import com.project.robotmate.admin.global.dto.response.DataResponse;
import com.project.robotmate.admin.global.dto.response.ApiResponse;
import com.project.robotmate.domain.entity.admin.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class NoticeApiController {

    private final NoticeService noticeService;

    @PostMapping(value = "/api/notices")
    public ResponseEntity<DataResponse<Long>> createNotice(
            @RequestBody NoticeRequest request, Admin admin
    ) {
        System.out.println("admin = " + admin);
        System.out.println("request = " + request);
        Long NoticeId = noticeService.save(request, admin);
        return ResponseEntity.ok(new DataResponse<>(NoticeId));
    }

    @PostMapping(value = "/api/noticesImg", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<DataResponse<String>> uploadImage(
            @ModelAttribute MultipartFile file
            ) {
        System.out.println("file = " + file);
        String url = noticeService.saveImg(file);
        return ResponseEntity.ok(new DataResponse<>(url));
    }


    @PutMapping(value = "/api/notices/{id}")
    public ResponseEntity<ApiResponse> editNotice(
            @RequestBody NoticeUpdateRequest request,
            @PathVariable("id") Long id
    ) {
        noticeService.update(id, request);
        return ResponseEntity.ok(ApiResponse.ok());
    }

    @DeleteMapping(value = "/api/notices/{id}")
    public ResponseEntity<ApiResponse> editNotice(
            @PathVariable("id") Long id
    ) {
        noticeService.delete(id);
        return ResponseEntity.ok(ApiResponse.ok());
    }
}
