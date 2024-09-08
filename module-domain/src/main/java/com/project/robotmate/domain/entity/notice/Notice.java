package com.project.robotmate.domain.entity.notice;

import com.project.robotmate.core.types.GalleryType;
import com.project.robotmate.core.types.NoticeType;
import com.project.robotmate.domain.entity.admin.Admin;
import com.project.robotmate.domain.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "RM_NOTICE")
public class Notice extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String contents;

    @Column(name = "view_cnt")
    private Integer viewCount;

    @Column(name = "pbc_yn")
    private String publicYn = "Y";

    @Column(name = "del_yn")
    private String delYn = "N";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Admin admin;

    @Column(name = "type")
    //enum String으로 쓸경우 써줘야함
    @Enumerated(EnumType.STRING)
    private NoticeType type;

    @Builder
    public Notice(Long id, String title, String contents, Integer viewCount, String publicYn, String delYn, Admin admin) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.viewCount = viewCount != null ? viewCount:0;
        this.publicYn = publicYn;
        this.delYn = delYn != null ? delYn : "N";
        this.admin = admin;
    }


    public  void increaseViewCount() {
        this.viewCount++;
    }

    public void changeNotice(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
    public void changeType(NoticeType type) {
        this.type = type;
    }

    public void remove() {
        this.delYn = "Y";
    }
}
