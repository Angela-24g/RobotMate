package com.project.robotmate.home.domain.notice.service;

import com.project.robotmate.domain.common.dto.Page;
import com.project.robotmate.domain.common.dto.Pageable;
import com.project.robotmate.domain.common.dto.Searchable;
import com.project.robotmate.domain.entity.notice.Notice;
import com.project.robotmate.domain.entity.notice.repository.NoticeQueryRepository;
import com.project.robotmate.home.domain.notice.dto.response.NoticeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DefaultNoticeService implements NoticeService {

    private final NoticeQueryRepository noticeQueryRepository;

    @Override
    public Page<List<NoticeResponse>> getNoticeList(Searchable searchable) {

        Long totalCount = noticeQueryRepository.countAllBySearchable(searchable);
        Pageable pageable = new Pageable(totalCount.intValue(), searchable.getPage(), 20);
        List<NoticeResponse> result = noticeQueryRepository.findAllBySearchable(pageable, searchable)
                                        .stream()
                                        .map(NoticeResponse::new)
                                        .collect(Collectors.toList());
        return new Page<>(pageable, result);
    }

//    @Override
//    public List<NoticeResponse> getNoticeList() {
//        return noticeQueryRepository.findAllBySearchable()
//                .stream().map(NoticeResponse::new)
//                .collect(Collectors.toList());
//    }

    @Override
    public List<NoticeResponse> getNoticeListDetail(HttpServletRequest req) {
        return null;
    }

    /**
     * Pageable 객체 가져오기
     */
    private Pageable getPageable(int totalCount, int page) {
        return new Pageable(totalCount, page);
    }
}
