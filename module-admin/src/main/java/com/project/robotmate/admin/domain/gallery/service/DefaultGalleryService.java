package com.project.robotmate.admin.domain.gallery.service;

import cloud.aws.s3.S3UploadProvider;
import cloud.aws.s3.model.S3File;
import com.project.robotmate.admin.domain.common.file.dto.FileData;
import com.project.robotmate.admin.domain.common.file.dto.TargetFileData;
import com.project.robotmate.admin.domain.common.file.service.FileService;
import com.project.robotmate.admin.domain.gallery.dto.request.GalleryRequest;
import com.project.robotmate.admin.domain.gallery.dto.response.GalleryResponse;
import com.project.robotmate.core.types.DirectoryType;
import com.project.robotmate.core.types.TargetType;
import com.project.robotmate.domain.common.dto.Page;
import com.project.robotmate.domain.common.dto.Pageable;
import com.project.robotmate.domain.common.dto.Searchable;
import com.project.robotmate.domain.entity.Admin;
import com.project.robotmate.domain.entity.Gallery;
import com.project.robotmate.domain.gallery.repository.GalleryQueryRepository;
import com.project.robotmate.domain.gallery.repository.GalleryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DefaultGalleryService implements GalleryService{

    private final GalleryRepository galleryRepository;
    private final GalleryQueryRepository galleryQueryRepository;
    private final FileService fileService;
    private final S3UploadProvider s3UploadProvider;
    @Override
    @Transactional
    public Long save(GalleryRequest request, Admin admin) {
        // 파일 업로드
        S3File s3File = s3UploadProvider.upload(request.getFile(), DirectoryType.GALLERY);
        Gallery gallery = Gallery.builder()
                .title(request.getTitle())
                .contents(request.getContents())
                .year(request.getYear())
                .type(request.getType())
                .admin(admin)
                .build();
        galleryRepository.save(gallery);
        TargetFileData target = new TargetFileData(gallery.getId(), TargetType.GALLERY);
        fileService.save(s3File, target);

        return gallery.getId();
    }

    @Override
    @Transactional
    public void update(Long id, GalleryRequest request) {
        Gallery gallery = galleryQueryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("찾을 수 없는 갤러리입니다"));


        if (!request.getFile().isEmpty()) {
            S3File s3File = s3UploadProvider.upload(request.getFile(), DirectoryType.GALLERY);
            TargetFileData target = new TargetFileData(gallery.getId(), TargetType.GALLERY);
            fileService.save(s3File, target);
        }

        gallery.changeGallery(request.getTitle(), request.getContents());
        gallery.changeYear(request.getYear());
        gallery.changeType(request.getType());
    }

    @Override
    public Page<List<GalleryResponse>> getGalleries(int page) {
        Long totalCount = galleryQueryRepository.countAll();
        Pageable pageable = getPageable(totalCount, page);
        List<Gallery> result = galleryQueryRepository.findAll(pageable);
        return new Page<>(pageable, getGalleryResponses(result));
    }

    @Override
    public Page<List<GalleryResponse>> getGalleries(Searchable searchable) {
        Long totalCount = galleryQueryRepository.countAllBySearchable(searchable);
        Pageable pageable = getPageable(totalCount, searchable.getPage());
        List<Gallery> result = galleryQueryRepository.findAllBySearchable(pageable, searchable);
        return new Page<>(pageable, getGalleryResponses(result));
    }


    @Override
    public GalleryResponse getGallery(Long id) {
        Gallery gallery = galleryQueryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("찾을 수 없는 갤러리입니다"));

        FileData file = fileService.getFile(gallery.getId(), TargetType.GALLERY);

        return new GalleryResponse(gallery, file.getBucket());
    }

    private List<GalleryResponse> getGalleryResponses(List<Gallery> result) {
        List<Long> targetIds = result.stream().map(Gallery::getId).collect(Collectors.toList());
        List<FileData> targetFiles = fileService.getTargetFile(targetIds, TargetType.GALLERY);

        return result.stream().map(r -> {
            FileData fileData = targetFiles.stream()
                    .filter(tf -> tf.getTargetId().equals(r.getId()))
                    .findFirst()
                    .orElseGet(null);
            return new GalleryResponse(r, fileData.getBucket());
        }).collect(Collectors.toList());
    }

    /**
     * Pageable 객체 가져오기
     * */
    private Pageable getPageable(long totalCount, int page) {
        return Pageable.builder()
                .totalCount(totalCount)
                .page(page)
                .build();
    }
}
