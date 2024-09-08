package com.project.robotmate.admin.domain.notice.dto.request;

import com.project.robotmate.core.types.NoticeType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class NoticeUpdateRequest {

    private String title;
    private String contents;
    private String publicYn;
    private String type;

    @Builder
    public NoticeUpdateRequest(String title, String contents, String publicYn, String type) {
        this.title = title;
        this.contents = contents;
        this.type = type;
        this.publicYn = publicYn;
    }

    public NoticeType getType() {
        if (type == null) {
            return null;
        }
        return NoticeType.valueOf(this.type.toUpperCase());
    }
}
