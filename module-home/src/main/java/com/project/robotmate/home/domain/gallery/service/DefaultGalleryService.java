package com.project.robotmate.home.domain.gallery.service;

import com.project.robotmate.core.types.TargetType;
import com.project.robotmate.domain.common.dto.Page;
import com.project.robotmate.domain.common.dto.Pageable;
import com.project.robotmate.domain.common.dto.Searchable;
import com.project.robotmate.domain.entity.gallery.Gallery;
import com.project.robotmate.domain.entity.gallery.repository.GalleryQueryRepository;
import com.project.robotmate.home.domain.file.dto.FileData;
import com.project.robotmate.home.domain.file.service.FileService;
import com.project.robotmate.home.domain.gallery.dto.response.GalleryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DefaultGalleryService implements GalleryService{

    private final GalleryQueryRepository galleryQueryRepository;
    private final FileService fileService;

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

    /**
     * gallery -> galleryResponse 로 변환
     * 해당 작업 진행시 fileData 하나를 추가합니다.
     * */
    private List<GalleryResponse> getGalleryResponses(List<Gallery> result) {
        List<Long> targetIds = result.stream().map(Gallery::getId).collect(Collectors.toList());
        List<FileData> targetFiles = fileService.getTargetFile(targetIds, TargetType.GALLERY);

        return result.stream().map(r -> {
            FileData fileData = targetFiles.stream()
                    .filter(tf -> tf.getTargetId().equals(r.getId()))
                    .findFirst()
                    .orElseGet(null);
            return new GalleryResponse(r, fileData);
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
