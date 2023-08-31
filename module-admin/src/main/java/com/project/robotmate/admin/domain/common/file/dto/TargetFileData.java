package com.project.robotmate.admin.domain.common.file.dto;

import com.project.robotmate.core.types.TargetType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TargetFileData {
    private Long targetId;
    private TargetType type;
    private String thumbnailBucket;

    public TargetFileData(Long targetId, TargetType type) {
        this(targetId, type, null);
    }

    public TargetFileData(Long targetId, TargetType type, String thumbnailBucket) {
        this.targetId = targetId;
        this.type = type;
        this.thumbnailBucket = thumbnailBucket;
    }
}
