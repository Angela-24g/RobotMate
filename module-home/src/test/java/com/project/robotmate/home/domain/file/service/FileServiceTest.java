package com.project.robotmate.home.domain.file.service;

import com.project.robotmate.core.types.TargetType;
import com.project.robotmate.domain.entity.File;
import com.project.robotmate.domain.file.repository.FileRepository;
import com.project.robotmate.home.domain.file.repository.FileQueryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import java.util.List;

@SpringBootTest
@Transactional
class FileServiceTest {

    @Autowired
    FileRepository fileRepository;
    @Autowired
    FileQueryRepository fileQueryRepository;
    @Autowired
    EntityManager em;

    @Test
    void test() {
        File file1 = File.builder()
                .displayOrder(1)
                .type(TargetType.GALLERY)
                .bucket("/test")
                .name("test")
                .targetId(1L)
                .build();

        File file2 = File.builder()
                .displayOrder(2)
                .type(TargetType.GALLERY)
                .bucket("/test")
                .name("test")
                .targetId(1L)
                .build();

        File file3 = File.builder()
                .displayOrder(1)
                .type(TargetType.GALLERY)
                .bucket("/test")
                .name("test")
                .targetId(2L)
                .build();

        File file4 = File.builder()
                .displayOrder(2)
                .type(TargetType.GALLERY)
                .bucket("/test")
                .name("test")
                .targetId(2L)
                .build();

        fileRepository.saveAll(List.of(file1,file2,file3,file4));

        em.flush();
        em.clear();

        List<File> inTargetIdAndType = fileQueryRepository.findInTargetIdAndType(List.of(1L, 2L), TargetType.GALLERY);

        for (File file : inTargetIdAndType) {
            System.out.println("file = " + file);
        }
    }
}