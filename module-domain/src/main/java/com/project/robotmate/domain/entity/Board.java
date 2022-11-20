package com.project.robotmate.domain.entity;

import com.project.robotmate.core.types.BoardType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "RM_BBS")
public class Board extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000)
    private String title;

    private String contents;

    @Column(name = "view_cnt")
    private Integer viewCount;

    @Column(name = "pbc_yn")
    private String publicYn;

    @Column(name = "bbs_type")
    private BoardType type;

    @Column(name = "del_yn")
    private String delYn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private User user;
}
