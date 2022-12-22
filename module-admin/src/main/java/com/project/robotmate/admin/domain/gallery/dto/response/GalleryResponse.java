package com.project.robotmate.admin.domain.gallery.dto.response;

import cloud.aws.s3.util.S3UrlUtil;
import com.project.robotmate.admin.domain.common.file.dto.FileData;
import com.project.robotmate.core.types.GalleryType;
import com.project.robotmate.domain.entity.File;
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
    private Long imageId;

    public GalleryResponse(Gallery gallery, FileData file) {
        this.id = gallery.getId();
        this.title = gallery.getTitle();
        this.contents = gallery.getContents();
        this.type = gallery.getType();
        this.imageUri = S3UrlUtil.conventUrl(file.getBucket());
        this.year = gallery.getYear();
        this.createDate = gallery.getCreatedDate();
        this.imageId = file.getId();
    }

}
