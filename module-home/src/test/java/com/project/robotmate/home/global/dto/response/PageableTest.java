package com.project.robotmate.home.global.dto.response;

import com.project.robotmate.domain.entity.Gallery;
import com.project.robotmate.domain.repository.gallery.GalleryRepository;
import com.project.robotmate.home.domain.gallery.repository.GalleryQueryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class PageableTest {

    @Autowired
    GalleryQueryRepository galleryQueryRepository;

    @Autowired
    GalleryRepository galleryRepository;

    @Autowired
    EntityManager em;

    @Test
    void test() {
        Pageable pageable = new Pageable(180, 19);

        System.out.println("pageable = " + pageable);
        System.out.println("pageable,getOffset = " + pageable.getOffset());

    }

    @Test
    @Transactional
    @Commit
    void test2() {

        Gallery gallery1 = Gallery.builder()
                .title("titleA")
                .contents("contentsA")
                .build();

        Gallery gallery2 = Gallery.builder()
                .title("titleB")
                .contents("contentsB")
                .build();

        Gallery gallery3 = Gallery.builder()
                .title("titleC")
                .contents("contentsC")
                .build();

        galleryRepository.saveAll(List.of(gallery1, gallery2, gallery3));

        em.flush();
        em.clear();

        Searchable searchable = new Searchable(1, null, "2022");
        Long total = galleryQueryRepository.countAllBySearchable(searchable);
        Pageable pageable = new Pageable(total, 1);
        List<Gallery> all = galleryQueryRepository.findAllBySearchable(pageable, searchable);

        System.out.println("all = " + all);

        for (Gallery gallery : all) {
            System.out.println("gallery = " + gallery.toString());
        }
    }

}