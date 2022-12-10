package com.project.robotmate.home.domain.notice.dto.response;

import com.project.robotmate.core.types.BoardType;
import com.project.robotmate.domain.entity.Admin;
import com.project.robotmate.domain.entity.Notice;
import com.project.robotmate.home.domain.admin.dto.response.AdminResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
public class NoticeResponse {

    private Long id;
    private String title;
    private String contents;
    private Integer viewCount;
    private String publicYn;
    private BoardType type;
    private AdminResponse admin;

    public NoticeResponse(Notice notice) {
        this.id = notice.getId();
        this.title = notice.getTitle();
        this.contents = notice.getContents();
        this.viewCount = notice.getViewCount();
        this.publicYn = notice.getPublicYn();
        this.admin = new AdminResponse(notice.getAdmin());
    }
}
