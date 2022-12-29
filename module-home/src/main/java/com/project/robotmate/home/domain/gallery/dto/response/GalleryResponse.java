package com.project.robotmate.home.domain.gallery.dto.response;

import com.project.robotmate.core.types.GalleryType;
import com.project.robotmate.domain.entity.gallery.Gallery;
import com.project.robotmate.home.domain.admin.dto.response.AdminResponse;
import com.project.robotmate.home.domain.file.dto.FileData;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class GalleryResponse {

    private Long id;
    private String title;
    private String contents;
    private String delYn;
    private GalleryType type;

    private String year;

    private LocalDateTime createDate;
    private FileData file;
    private AdminResponse admin;

    public GalleryResponse(Gallery gallery, FileData file) {
        this.id = gallery.getId();
        this.title = gallery.getTitle();
        this.contents = gallery.getContents();
        this.delYn = gallery.getDelYn();
        this.type = gallery.getType();
        this.admin = new AdminResponse(gallery.getAdmin());
        this.file = file;
        this.year = gallery.getYear();
        this.createDate = gallery.getCreatedDate();
    }
}
