package cloud.aws.s3;

import cloud.aws.s3.config.AwsS3BucketProvider;
import cloud.aws.s3.model.S3File;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.project.robotmate.core.types.DirectoryType;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static cloud.aws.s3.util.AwsUtil.createFilename;

public class DefaultS3UploadProvider implements S3UploadProvider {

    private final AmazonS3Client amazonS3Client;
    private final AwsS3BucketProvider provider;

    public DefaultS3UploadProvider(AmazonS3Client amazonS3Client, AwsS3BucketProvider provider) {
        this.amazonS3Client = amazonS3Client;
        this.provider = provider;
    }

    @Override
    public S3File upload(MultipartFile file, DirectoryType type) {
        checkEmptyFile(file);
        String s3FileName = createFilename(type.getValue());

        try {
            ObjectMetadata objMeta = new ObjectMetadata();
            objMeta.setContentLength(file.getInputStream().available());
            objMeta.setContentType(file.getContentType());

            PutObjectRequest putObjectRequest = new PutObjectRequest(
                    provider.getBucket(),
                    s3FileName,
                    file.getInputStream(),
                    objMeta
            );
            amazonS3Client.putObject(putObjectRequest);

            return getS3File(1, file, s3FileName);

        } catch (Exception e) {
            System.out.println("e = " + e);
            throw new IllegalArgumentException("파일 업로드에 실패했습니다.");
        }
    }

    @Override
    public S3File upload(File file, DirectoryType type) {
        checkEmptyFile(file);
        String s3FileName = createFilename(type.getValue());

        try {
            ObjectMetadata objMeta = new ObjectMetadata();
            objMeta.setContentLength(file.length());

            PutObjectRequest putObjectRequest = new PutObjectRequest(
                    provider.getBucket(),
                    s3FileName,
                    file
            );
            amazonS3Client.putObject(putObjectRequest);

            return getS3File(1, file, s3FileName);

        } catch (Exception e) {
            System.out.println("e = " + e);
            throw new IllegalArgumentException("파일 업로드에 실패했습니다.");
        }
    }

    @Override
    public List<S3File> uploadAll(List<MultipartFile> files, DirectoryType type) {
        List<S3File> result = new ArrayList<>();
        for (int i = 0 ; i < files.size() ; i++) {
            result.add(upload(files.get(i), type));
        }
        return result;
    }

    private S3File getS3File(int index, MultipartFile file, String bucket) {
        S3File s3File = new S3File();
        s3File.setBucket(bucket);
        s3File.setIndex(index);
        s3File.setFormat(file.getContentType());
        s3File.setOriginalFileName(file.getOriginalFilename());
        s3File.setSize(file.getSize());

        return s3File;
    }

    private S3File getS3File(int index, File file, String bucket) {
        S3File s3File = new S3File();
        s3File.setBucket(bucket);
        s3File.setIndex(index);
        s3File.setFormat(FilenameUtils.getExtension(file.getName()));
        s3File.setOriginalFileName(file.getName());
        s3File.setSize(file.length());

        return s3File;
    }

    private void checkEmptyFile(MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("업로드할 파일이 존재하지 않습니다.");
        }
    }

    private void checkEmptyFile(File file) {
        if (file == null) {
            throw new IllegalArgumentException("업로드할 파일이 존재하지 않습니다.");
        }
    }
}
