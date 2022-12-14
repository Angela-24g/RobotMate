package com.project.robotmate.admin.domain.gallery.dto.request;

import com.project.robotmate.core.types.GalleryType;
import lombok.Getter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@ToString
public class GalleryCreateRequest {

    private String title;
    private String contents;
    private String type;
    private String year;
    private MultipartFile file;

    public GalleryCreateRequest(String title, String contents, String type, String year, MultipartFile file) {
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
