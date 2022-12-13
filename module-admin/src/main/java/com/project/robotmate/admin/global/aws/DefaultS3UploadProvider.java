package com.project.robotmate.admin.global.aws;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;

import com.amazonaws.services.s3.model.PutObjectRequest;
import com.project.robotmate.admin.global.aws.model.S3File;
import com.project.robotmate.core.types.DirectoryType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import static com.project.robotmate.admin.global.aws.util.AwsUtil.*;

@Component
@RequiredArgsConstructor
public class DefaultS3UploadProvider implements S3UploadProvider{

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;
    private final AmazonS3 amazonS3;

    public S3File upload(MultipartFile file, DirectoryType type) {
        checkEmptyFile(file);
        String s3FileName = createFilename(type.getValue());

        try {
            ObjectMetadata objMeta = new ObjectMetadata();
            objMeta.setContentLength(file.getInputStream().available());
            objMeta.setContentType(file.getContentType());

            PutObjectRequest putObjectRequest = new PutObjectRequest(
                    bucket,
                    s3FileName,
                    file.getInputStream(),
                    objMeta
            );

            amazonS3.putObject(putObjectRequest);

            return getS3File(1, file, s3FileName);

        } catch (Exception e) {
            throw new IllegalArgumentException("파일 업로드에 실패했습니다.");
        }
    }

    private static S3File getS3File(int index, MultipartFile file, String bucket) {
        return S3File.builder()
                .format(file.getContentType())
                .originalFileName(file.getOriginalFilename())
                .size(file.getSize())
                .bucket(bucket)
                .index(index)
                .build();
    }

    private void checkEmptyFile(MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("업로드할 파일이 존재하지 않습니다.");
        }
    }
}
