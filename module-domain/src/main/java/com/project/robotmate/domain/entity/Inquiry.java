package com.project.robotmate.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "RM_REQ")
public class Inquiry extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000)
    private String title;

    private String contents;

    @Column(name = "del_yn")
    private String delYn = "N";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private User user;

    @Builder
    public Inquiry(Long id, String title, String contents, String delYn, User user) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.delYn = delYn != null ? delYn : "N";
        this.user = user;
    }
}
