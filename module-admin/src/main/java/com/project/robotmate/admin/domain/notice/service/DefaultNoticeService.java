package com.project.robotmate.admin.domain.notice.service;

import cloud.aws.s3.S3UploadProvider;
import cloud.aws.s3.model.S3File;
import cloud.aws.s3.util.S3UrlUtil;
import com.project.robotmate.admin.domain.common.file.dto.FileData;
import com.project.robotmate.admin.domain.common.file.dto.TargetFileData;
import com.project.robotmate.admin.domain.common.file.provider.ThumbnailProvider;
import com.project.robotmate.admin.domain.common.file.service.FileService;
import com.project.robotmate.admin.domain.gallery.dto.request.GalleryUpdateRequest;
import com.project.robotmate.admin.domain.notice.dto.request.NoticeRequest;
import com.project.robotmate.admin.domain.notice.dto.response.NoticeResponse;
import com.project.robotmate.core.types.DirectoryType;
import com.project.robotmate.core.types.GalleryType;
import com.project.robotmate.core.types.NoticeType;
import com.project.robotmate.core.types.TargetType;
import com.project.robotmate.domain.common.dto.Page;
import com.project.robotmate.domain.common.dto.Pageable;
import com.project.robotmate.domain.entity.gallery.Gallery;
import com.project.robotmate.domain.entity.notice.repository.NoticeQueryRepository;
import com.project.robotmate.domain.entity.admin.Admin;
import com.project.robotmate.domain.entity.notice.Notice;
import com.project.robotmate.domain.entity.notice.repository.NoticeRepository;
import com.project.robotmate.admin.domain.notice.dto.request.NoticeUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DefaultNoticeService implements NoticeService{

    private final NoticeRepository noticeRepository;
    private final NoticeQueryRepository noticeQueryRepository;
    private final FileService fileService;
    private final S3UploadProvider s3UploadProvider;
    private final ThumbnailProvider thumbnailProvider;


    @Override
    @Transactional
    public Long save(NoticeRequest request, Admin admin) {
        // 파일이 있으면 업로드
        Notice notice = Notice.builder()
                .title(request.getTitle())
                .contents(request.getContents())
                .publicYn(request.getPublicYn())
                .admin(admin)
                .build();
        noticeRepository.save(notice);
//        target.setThumbnailBucket(thumbnail);

        return notice.getId();
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
                .orElseThrow(() -> new IllegalArgumentException("찾을 수 없는 공지사항입니다"));

      //  FileData file = fileService.getFile(notice.getId(), TargetType.NOTICE);

        return new NoticeResponse(notice);
    }

    @Override
    public String saveImg(MultipartFile file) {
        S3File s3File = s3UploadProvider.upload(file, DirectoryType.NOTICE);
        return S3UrlUtil.conventUrl( s3File.getBucket() );
    }

    @Override
    @Transactional
    public void update(Long id, NoticeUpdateRequest request) {
        Notice notice = noticeQueryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("찾을 수 없는 공지사항입니다"));

        notice.changeNotice(request.getTitle(), request.getContents());
        notice.changeType(request.getType());

    }

    @Override
    @Transactional
    public void delete(Long id) {
        Notice notice = noticeQueryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("찾을 수 없는 공지사항입니다"));
        notice.remove();
    }


}
