package com.project.robotmate.domain.entity;

import com.project.robotmate.core.types.BoardType;
import com.project.robotmate.core.types.TargetType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "RM_FILE")
public class File extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    private TargetType type;

    @Column(length = 500)
    private String bucket;

    @Column(name = "ori_file_nm", length = 500)
    private String originalFileName;

    @Column(name = "nm", length = 500)
    private String name;

    @Column(name = "file_format", length = 50)
    private String fileFormat;

    private int size;

    @Column(name = "target_id")
    private Long targetId;

    @Column(name = "del_yn")
    private String delYn;
}
