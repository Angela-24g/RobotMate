package com.project.robotmate.domain.file.repository;

import com.project.robotmate.core.types.TargetType;
import com.project.robotmate.domain.entity.File;

import java.util.List;


public interface FileQueryRepository {

    List<File> findInTargetIdAndType(List<Long> targetIds, TargetType type);
}
