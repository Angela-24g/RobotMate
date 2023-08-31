package com.project.robotmate.admin.domain.gallery.dto.response;

import cloud.aws.s3.util.S3UrlUtil;
import com.project.robotmate.admin.domain.common.file.dto.FileData;
import com.project.robotmate.core.types.GalleryType;
import com.project.robotmate.domain.entity.gallery.Gallery;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.ObjectUtils;

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
    private String fileType;
    private String originalImageUri;

    public GalleryResponse(Gallery gallery, FileData file) {
        this.id = gallery.getId();
        this.title = gallery.getTitle();
        this.contents = gallery.getContents();
        this.type = gallery.getType();
        this.imageUri = ObjectUtils.isEmpty(file.getThumbnailBucket()) ?
                S3UrlUtil.conventUrl(file.getBucket()) : S3UrlUtil.conventUrl(file.getThumbnailBucket());
        this.originalImageUri = S3UrlUtil.conventUrl(file.getBucket());
        this.year = gallery.getYear();
        this.createDate = gallery.getCreatedDate();
        this.imageId = file.getId();
        this.fileType = file.getFileFormat();
    }

    public String typeToKor() {
        if (GalleryType.AWARD.equals(this.type)) {
            return "수상내역";
        } else if (GalleryType.MAIN.equals(this.type)) {
            return "메인이미지";
        } else {
            return "일반";
        }
    }

    public String typeToClassName() {
        if (GalleryType.AWARD.equals(this.type)) {
            return "bg-info";
        } else if (GalleryType.MAIN.equals(this.type)) {
            return "bg-danger";
        } else {
            return "bg-primary";
        }
    }
}
