package com.project.robotmate.admin.domain.gallery.dto.request;

import com.project.robotmate.core.types.GalleryType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Getter
@ToString
public class GalleryUpdateRequest {

    @Max(value = 10)
    private String title;

    @Max(value = 100)
    private String contents;

    @NotBlank
    private String type;

    @NotBlank
    private String year;

    private Long fileId;

    private Integer order;

    private MultipartFile file;

    @Builder
    public GalleryUpdateRequest(String title, String contents, String type, String year, Long fileId, Integer order, MultipartFile file) {
        this.title = title;
        this.contents = contents;
        this.type = type;
        this.year = year;
        this.fileId = fileId;
        this.order = order;
        this.file = file;
    }

    public GalleryType getType() {
        if (type == null) {
            return null;
        }
        return GalleryType.valueOf(this.type.toUpperCase());
    }
}
