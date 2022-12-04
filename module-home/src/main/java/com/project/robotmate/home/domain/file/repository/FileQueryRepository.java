package com.project.robotmate.home.domain.file.repository;

import com.project.robotmate.core.types.TargetType;
import com.project.robotmate.domain.entity.File;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface FileQueryRepository {

    List<File> findInTargetIdAndType(List<Long> targetIds, TargetType type);
}
