package com.project.robotmate.admin.domain.common.file.service;

import cloud.aws.s3.model.S3File;
import com.project.robotmate.admin.domain.common.file.dto.FileData;
import com.project.robotmate.admin.domain.common.file.dto.TargetFileData;
import com.project.robotmate.core.types.TargetType;
import com.project.robotmate.domain.entity.File;
import com.project.robotmate.domain.file.repository.FileQueryRepository;
import com.project.robotmate.domain.file.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DefaultFileService implements FileService {

    private final FileRepository fileRepository;
    private final FileQueryRepository fileQueryRepository;

    @Override
    public File save(S3File s3File, TargetFileData target) {
        File file = s3FileToFileEntity(s3File, target);
        fileRepository.save(file);
        return file;
    }

    @Override
    public List<FileData> getFiles(Long targetId, TargetType type) {
        return fileRepository.findAllByTargetIdAndType(targetId, type)
                .stream()
                .map(FileData::new)
                .collect(Collectors.toList());
    }

    @Override
    public FileData getFile(Long targetId, TargetType type) {
        File file = fileRepository.findByTargetIdAndType(targetId, type)
                .orElseThrow(() -> new IllegalArgumentException("찾을 수 없는 파일입니다."));
        return new FileData(file);
    }

    @Override
    public List<FileData> getTargetFile(List<Long> targetIds, TargetType type) {
        return fileQueryRepository.findInTargetIdAndType(targetIds, type)
                .stream().map(FileData::new).collect(Collectors.toList());
    }

    @Override
    public File s3FileToFileEntity(S3File s3File, TargetFileData target) {
        return File.builder()
                .bucket(s3File.getBucket())
                .fileFormat(s3File.getFormat())
                .displayOrder(s3File.getIndex())
                .name(s3File.getOriginalFileName())
                .originalFileName(s3File.getOriginalFileName())
                .size(s3File.getSize())
                .type(target.getType())
                .targetId(target.getTargetId())
                .build();
    }

}
