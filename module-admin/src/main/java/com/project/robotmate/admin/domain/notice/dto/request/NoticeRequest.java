package com.project.robotmate.admin.domain.notice.dto.request;

import com.project.robotmate.core.types.BoardType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
public class NoticeRequest {

    private String title;
    private String contents;
    private String publicYn;
    private MultipartFile file;

    public NoticeRequest(String title, String contents, String publicYn, MultipartFile file) {
        this.title = title;
        this.contents = contents;
        this.publicYn = publicYn;
        this.file = file;
    }
}
