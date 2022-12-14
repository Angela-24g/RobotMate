package com.project.robotmate.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "RM_NOTICE")
public class Notice extends BaseEntity{

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
    private String publicYn;

    @Column(name = "del_yn")
    private String delYn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Admin admin;

    @Builder
    public Notice(Long id, String title, String contents, Integer viewCount, String publicYn, String delYn, Admin admin) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.viewCount = viewCount;
        this.publicYn = publicYn;
        this.delYn = delYn;
        this.admin = admin;
    }
}
