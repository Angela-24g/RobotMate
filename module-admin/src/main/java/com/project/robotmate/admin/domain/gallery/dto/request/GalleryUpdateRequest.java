package com.project.robotmate.admin.domain.gallery.dto.request;

import com.project.robotmate.core.types.GalleryType;
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

    private MultipartFile file;

    public GalleryUpdateRequest(String title, String contents, String type, String year, MultipartFile file, Long fileId) {
        this.title = title;
        this.contents = contents;
        this.type = type;
        this.year = year;
        this.file = file;
        this.fileId = fileId;
    }

    public GalleryType getType() {
        if (type == null) {
            return null;
        }
        return GalleryType.valueOf(this.type.toUpperCase());
    }
}
