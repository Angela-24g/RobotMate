package com.project.robotmate.admin.domain.notice.dto.response;

import com.project.robotmate.admin.domain.admin.dto.response.AdminResponse;
import com.project.robotmate.core.types.BoardType;
import com.project.robotmate.domain.entity.Notice;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class NoticeResponse {

    private Long id;
    private String title;
    private String contents;
    private Integer viewCount;
    private String publicYn;
    private AdminResponse admin;

    private LocalDateTime createDate;

    public NoticeResponse(Notice notice) {
        this.id = notice.getId();
        this.title = notice.getTitle();
        this.contents = notice.getContents();
        this.viewCount = notice.getViewCount();
        this.publicYn = notice.getPublicYn();
        if (admin != null){
            this.admin = new AdminResponse(notice.getAdmin());
        }

        this.createDate = notice.getCreatedDate();
    }
}
