package com.project.robotmate.admin.domain.gallery.dto.request;

import com.project.robotmate.core.types.GalleryType;
import lombok.Getter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Getter
@ToString
public class GalleryRequest {

    @Max(value = 10)
    private String title;

    @Max(value = 100)
    private String contents;

    @NotBlank
    private String type;

    @NotBlank
    private String year;

    private MultipartFile file;

    public GalleryRequest(String title, String contents, String type, String year, MultipartFile file) {
        this.title = title;
        this.contents = contents;
        this.type = type;
        this.year = year;
        this.file = file;
    }

    public GalleryType getType() {
        if (type == null) {
            return null;
        }
        return GalleryType.valueOf(this.type.toUpperCase());
    }
}
