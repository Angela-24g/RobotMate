package com.project.robotmate.admin.global.aws.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class S3File {

    private int index;
    private String originalFileName;
    private String bucket;
    private String format;
    private Long size;

    @Builder
    public S3File(int index, String originalFileName, String name, String bucket, String format, Long size) {
        this.index = index;
        this.originalFileName = originalFileName;
        this.bucket = bucket;
        this.format = format;
        this.size = size;
    }
}
