package com.project.robotmate.home.domain.file.service;

import com.project.robotmate.core.types.TargetType;
import com.project.robotmate.domain.entity.file.File;
import com.project.robotmate.domain.entity.file.repository.FileQueryRepository;
import com.project.robotmate.domain.entity.file.repository.FileRepository;
import com.project.robotmate.home.domain.file.dto.FileData;
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

}
