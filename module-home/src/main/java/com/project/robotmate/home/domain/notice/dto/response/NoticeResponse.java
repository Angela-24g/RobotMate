package com.project.robotmate.home.domain.notice.dto.response;

import com.project.robotmate.core.types.BoardType;
import com.project.robotmate.domain.entity.notice.Notice;
import com.project.robotmate.home.domain.admin.dto.response.AdminResponse;
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
    private LocalDateTime createDt;
    private LocalDateTime modDt;
    private Integer viewCount;
    private String publicYn;
    private BoardType type;
    private AdminResponse admin;

    private String displayCreateDate;

    public NoticeResponse(Notice notice) {
        this.id = notice.getId();
        this.title = notice.getTitle();
        this.createDt = notice.getCreatedDate();
        this.modDt = notice.getModDate();
        this.contents = notice.getContents();
        this.viewCount = notice.getViewCount();
        this.publicYn = notice.getPublicYn();
        this.admin = new AdminResponse(notice.getAdmin());

        this.displayCreateDate = notice.getModDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
}
