package com.project.robotmate.domain.entity.file.repository;

import com.project.robotmate.core.types.TargetType;
import com.project.robotmate.domain.entity.file.File;
import com.project.robotmate.domain.entity.file.QFile;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.project.robotmate.domain.entity.file.QFile.file;


@Repository
@RequiredArgsConstructor
public class DefaultFileQueryRepository implements FileQueryRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<File> findInTargetIdAndType(List<Long> targetIds, TargetType type) {
        return queryFactory.selectFrom(file)
                .where(
                    file.targetId.in(targetIds),
                    file.type.eq(type),
                    file.displayOrder.eq(1),
                    file.delYn.eq("N")
                ).fetch();
    }

}
