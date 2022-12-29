package com.project.robotmate.home.domain.notice.service;

import com.project.robotmate.domain.common.dto.Page;
import com.project.robotmate.domain.common.dto.Pageable;
import com.project.robotmate.domain.entity.notice.repository.NoticeQueryRepository;
import com.project.robotmate.home.domain.notice.dto.response.NoticeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DefaultNoticeService implements NoticeService{

    private final NoticeQueryRepository noticeQueryRepository;

    @Override
    public Page<List<NoticeResponse>> getNotices(int page) {
        Long totalCount = noticeQueryRepository.countAll();
        Pageable pageable = getPageable(page, totalCount);
        List<NoticeResponse> result = noticeQueryRepository.findAll(pageable)
                .stream().map(NoticeResponse::new)
                .collect(Collectors.toList());

        return new Page<>(pageable, result);
    }

    private Pageable getPageable(int page, Long totalCount) {
        return Pageable.builder()
                .page(page)
                .totalCount(totalCount)
                .build();
    }
}
