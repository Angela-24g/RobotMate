package com.project.robotmate.admin.domain.common.file.dto;

import com.project.robotmate.core.types.TargetType;
import com.project.robotmate.domain.entity.File;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileData {

    private Long id;
    private TargetType type;
    private String bucket;
    private String originalFileName;
    private String name;
    private String fileFormat;
    private Long size;
    private Long targetId;
    private int displayOrder;

    public FileData(File file) {
        this.id = file.getId();
        this.type = file.getType();
        this.bucket = file.getBucket();
        this.originalFileName = file.getOriginalFileName();
        this.name = file.getName();
        this.fileFormat = file.getFileFormat();
        this.size = file.getSize();
        this.targetId = file.getTargetId();
        this.displayOrder = file.getDisplayOrder();
    }
}

