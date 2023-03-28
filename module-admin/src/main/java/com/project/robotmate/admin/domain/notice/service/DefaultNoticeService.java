package com.project.robotmate.admin.domain.notice.service;

import com.project.robotmate.admin.domain.common.file.dto.FileData;
import com.project.robotmate.admin.domain.common.file.service.FileService;
import com.project.robotmate.admin.domain.notice.dto.request.NoticeRequest;
import com.project.robotmate.admin.domain.notice.dto.response.NoticeResponse;
import com.project.robotmate.core.types.TargetType;
import com.project.robotmate.domain.common.dto.Page;
import com.project.robotmate.domain.common.dto.Pageable;
import com.project.robotmate.domain.entity.notice.repository.NoticeQueryRepository;
import com.project.robotmate.domain.entity.admin.Admin;
import com.project.robotmate.domain.entity.notice.Notice;
import com.project.robotmate.domain.entity.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DefaultNoticeService implements NoticeService{

    private final NoticeRepository noticeRepository;
    private final NoticeQueryRepository noticeQueryRepository;
    private final FileService fileService;

    @Override
    @Transactional
    public void save(NoticeRequest request, Admin admin) {
        Notice notice = Notice.builder()
                .title(request.getTitle())
                .contents(request.getContents())
                .publicYn(request.getPublicYn())
                .admin(admin)
                .build();
        noticeRepository.save(notice);
    }

    @Override
    public Page<List<NoticeResponse>> getNotices(int page) {
        Long totalCount = noticeQueryRepository.countAll();
        Pageable pageable = getPageable(page, totalCount.intValue());
        List<NoticeResponse> result = noticeQueryRepository.findAll(pageable)
                .stream().map(NoticeResponse::new)
                .collect(Collectors.toList());
        System.out.println("result = " + result);
        return new Page<>(pageable, result);
    }

    private Pageable getPageable(int page, int totalCount) {
        return new Pageable(totalCount, page);
    }

    @Override
    public NoticeResponse getNotice(Long id) {
        Notice notice = noticeQueryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("찾을 수 없는 갤러리입니다"));

      //  FileData file = fileService.getFile(notice.getId(), TargetType.NOTICE);

        return new NoticeResponse(notice);
    }






}
