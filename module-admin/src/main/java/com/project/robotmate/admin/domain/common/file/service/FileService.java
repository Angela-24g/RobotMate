package com.project.robotmate.admin.domain.common.file.service;

import cloud.aws.s3.model.S3File;
import com.project.robotmate.admin.domain.common.file.dto.FileData;
import com.project.robotmate.admin.domain.common.file.dto.TargetFileData;
import com.project.robotmate.core.types.TargetType;
import com.project.robotmate.domain.entity.File;


import java.util.List;

public interface FileService {


    File save(S3File s3File, TargetFileData target);

    /**
     * target 의 파일 목록 조회
     * @param targetId  타겟 식별자
     * @param type      타겟 종류
     * */
    List<FileData> getFiles(Long targetId, TargetType type);

    /**
     * target 단일 파일 조회
     * @param targetId  타겟 식별자
     * @param type      타겟 종류
     * */
    FileData getFile(Long targetId, TargetType type);

    /**
     * target 식별자들의 base 이미지 파일 조회
     * @param targetIds 타겟 식별자 목록
     * @param type      타겟 종류
     * */
    List<FileData> getTargetFile(List<Long> targetIds, TargetType type);

    File s3FileToFileEntity(S3File s3File, TargetFileData target);

    File getFileById(Long fileId);

    void deleteFile(Long fileId);
}
