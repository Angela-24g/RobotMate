package com.project.robotmate.admin.domain.notice.dto.request;

import com.project.robotmate.core.types.BoardType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class NoticeRequest {

    private String title;
    private String contents;
    private String publicYn;
}
