package com.project.robotmate.admin.domain.notice.dto.response;

import com.project.robotmate.admin.domain.admin.dto.response.AdminResponse;
import com.project.robotmate.domain.entity.notice.Notice;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    private String displayCreateDate;
    private String displayModDate;

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
        this.displayCreateDate = notice.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        this.displayModDate = notice.getModDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
}
