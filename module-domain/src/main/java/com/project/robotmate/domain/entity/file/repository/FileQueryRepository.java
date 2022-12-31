package com.project.robotmate.domain.entity.file.repository;

import com.project.robotmate.core.types.TargetType;
import com.project.robotmate.domain.entity.file.File;

import java.util.List;


public interface FileQueryRepository {

    List<File> findInTargetIdAndType(List<Long> targetIds, TargetType type);
}
