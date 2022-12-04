package com.project.robotmate.home.domain.file.service;

import com.project.robotmate.core.types.TargetType;
import com.project.robotmate.home.domain.file.dto.FileData;

import java.util.List;
import java.util.Optional;

public interface FileService {

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
}
