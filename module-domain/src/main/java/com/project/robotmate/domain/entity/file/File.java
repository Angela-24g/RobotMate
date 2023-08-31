package com.project.robotmate.domain.entity.file;

import com.project.robotmate.core.types.TargetType;
import com.project.robotmate.domain.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "RM_FILE")
@ToString
public class File extends BaseEntity {

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

    private Long size;

    @Column(name = "target_id")
    private Long targetId;

    @Column(name = "display_order")
    private int displayOrder;

    @Column(name = "thumbnail_bucket")
    public String thumbnailBucket;

    @Column(name = "del_yn")
    private String delYn = "N";

    @Builder
    public File(Long id, TargetType type, String bucket, String originalFileName, String name, String fileFormat, Long size, Long targetId, int displayOrder, String thumbnailBucket, String delYn) {
        this.id = id;
        this.type = type;
        this.bucket = bucket;
        this.originalFileName = originalFileName;
        this.name = name;
        this.fileFormat = fileFormat;
        this.size = size;
        this.targetId = targetId;
        this.displayOrder = displayOrder;
        this.thumbnailBucket = thumbnailBucket;
        this.delYn = delYn;
    }

    public void delete() {
        this.delYn = "Y";
    }
}
