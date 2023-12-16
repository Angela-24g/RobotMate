package com.project.robotmate.domain.entity.notice.repository;

import com.project.robotmate.core.types.NoticeType;
import com.project.robotmate.domain.common.dto.Pageable;
import com.project.robotmate.domain.entity.gallery.Gallery;
import com.project.robotmate.domain.common.dto.Searchable;
import com.project.robotmate.domain.entity.notice.Notice;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

import static com.project.robotmate.domain.entity.gallery.QGallery.gallery;
import static com.project.robotmate.domain.entity.notice.QNotice.notice;


@Repository
@RequiredArgsConstructor
public class DefaultNoticeQueryRepository implements NoticeQueryRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Notice> findAll(Pageable pageable) {
        return queryFactory.selectFrom(notice)
                .where(notDelete())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    @Override
    public Long countAll() {
        return queryFactory.select(notice.count())
                .from(notice)
                .where(notDelete())
                .fetchOne();
    }

    private BooleanExpression notDelete() {
        return notice.delYn.eq("N");
    }

    @Override
    public Optional<Notice> findById(Long id) {
        return Optional.ofNullable(
                queryFactory
                        .selectFrom(notice)
                        .where(notDelete(), notice.id.eq(id))
                        .fetchOne()
        );
    }

    @Override
    public List<Notice> findAllBySearchable(Pageable pageable, Searchable searchable) {
        return queryFactory.selectFrom(notice)
                .where(typeEq(searchable.getType()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        // notDelete 는 뭔지?

    }


    @Override
    public Long countAllBySearchable(Searchable searchable){
        return queryFactory.select(notice.count())
                .where(typeEq(searchable.getType()))
                .from(notice)
                .fetchOne();
    }


    private BooleanExpression typeEq(String type){
        if (ObjectUtils.isEmpty(type)) {
            return null;
        }
        try {
            return notice.type.eq(NoticeType.valueOf(type));
        } catch (Exception e) {
            return null;
        }
    }



}
