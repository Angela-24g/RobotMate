package com.project.robotmate.admin.domain.gallery.dto.response;

import com.project.robotmate.admin.global.util.S3UrlUtil;
import com.project.robotmate.core.types.GalleryType;
import com.project.robotmate.domain.entity.Gallery;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class GalleryResponse {

    private Long id;
    private String title;
    private String contents;
    private GalleryType type;
    private String year;
    private LocalDateTime createDate;
    private String imageUri;

    public GalleryResponse(Gallery gallery, String bucket) {
        this.id = gallery.getId();
        this.title = gallery.getTitle();
        this.contents = gallery.getContents();
        this.type = gallery.getType();
        this.imageUri = S3UrlUtil.conventUrl(bucket);
        this.year = gallery.getYear();
        this.createDate = gallery.getCreatedDate();
    }
}
