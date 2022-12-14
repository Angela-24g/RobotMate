package com.project.robotmate.domain.gallery.repository;

import com.project.robotmate.core.types.GalleryType;
import com.project.robotmate.domain.common.dto.Pageable;
import com.project.robotmate.domain.common.dto.Searchable;
import com.project.robotmate.domain.entity.Gallery;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.project.robotmate.domain.entity.QGallery.gallery;

@Repository
@RequiredArgsConstructor
public class DefaultGalleryQueryRepository implements GalleryQueryRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Gallery> findAll(Pageable pageable) {
        return queryFactory.selectFrom(gallery)
                .where(notDelete())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }


    @Override
    public Long countAll() {
        return queryFactory.select(gallery.count())
                .from(gallery)
                .where(notDelete())
                .fetchOne();
    }

    @Override
    public List<Gallery> findAllBySearchable(Pageable pageable, Searchable searchable) {
        return queryFactory.selectFrom(gallery)
                .where(typeEq(searchable.getType()), yearEq(searchable.getYear()), notDelete())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    @Override
    public Long countAllBySearchable(Searchable searchable) {
        return queryFactory.select(gallery.count())
                .where(typeEq(searchable.getType()), yearEq(searchable.getYear()), notDelete())
                .from(gallery)
                .fetchOne();
    }

    private BooleanExpression typeEq(String type) {
        if (type == null) {
            return null;
        }
        return gallery.type.eq(GalleryType.valueOf(type));
    }

    private BooleanExpression yearEq(String year) {
        if (year == null) {
            return null;
        }
        return gallery.year.eq(year);
    }

    private BooleanExpression notDelete() {
        return gallery.delYn.eq("N");
    }
}
