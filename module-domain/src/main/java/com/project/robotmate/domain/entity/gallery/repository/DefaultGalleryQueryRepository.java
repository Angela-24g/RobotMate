package com.project.robotmate.domain.entity.gallery.repository;

import com.project.robotmate.core.types.GalleryType;
import com.project.robotmate.domain.common.dto.Pageable;
import com.project.robotmate.domain.common.dto.Searchable;
import com.project.robotmate.domain.entity.gallery.Gallery;
import com.project.robotmate.global.util.DateUtil;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

import static com.project.robotmate.domain.entity.gallery.QGallery.gallery;


@Repository
@RequiredArgsConstructor
public class DefaultGalleryQueryRepository implements GalleryQueryRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<Gallery> findById(Long id) {
        return Optional.ofNullable(
                queryFactory
                        .selectFrom(gallery)
                        .where(notDelete(), gallery.id.eq(id))
                        .fetchOne()
        );
    }

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
                .orderBy(gallery.order.asc())
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

    @Override
    public List<Gallery> findTop6ByAward() {
        return queryFactory.select(gallery)
                .from(gallery)
                .where(typeEq("AWARD"), notDelete())
                .orderBy(gallery.year.desc())
                .offset(0)
                .limit(6)
                .fetch();
    }

    @Override
    public List<Gallery> findAllByMainType() {
        return queryFactory.select(gallery)
                .from(gallery)
                .where(typeEq("MAIN"), notDelete())
                .orderBy(gallery.order.asc())
                .fetch();
    }

    @Override
    public List<Gallery> findByAllByOld(Pageable pageable) {
        List<String> years = DateUtil.getYears();
        String year = years.get(years.size() - 1);
        return queryFactory.selectFrom(gallery)
                .where(notDelete(), gallery.year.castToNum(Integer.class).lt(Integer.parseInt(year)))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    @Override
    public Long countByAllByOld() {
        List<String> years = DateUtil.getYears();
        String year = years.get(years.size() - 1);
        return queryFactory.select(gallery.count())
                .where(notDelete(), gallery.year.castToNum(Integer.class).lt(Integer.parseInt(year)))
                .from(gallery)
                .fetchOne();
    }

    private BooleanExpression typeEq(String type) {
        if (ObjectUtils.isEmpty(type)) {
            return null;
        }
        try {
            return gallery.type.eq(GalleryType.valueOf(type));
        } catch (Exception e) {
            return null;
        }
    }

    private BooleanExpression yearEq(String year) {
        if (ObjectUtils.isEmpty(year)) {
            return null;
        }
        return gallery.year.eq(year);
    }

    private BooleanExpression notDelete() {
        return gallery.delYn.eq("N");
    }
}
