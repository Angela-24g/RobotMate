package cloud.aws.s3;

import cloud.aws.s3.model.S3File;
import com.project.robotmate.core.types.DirectoryType;
import org.springframework.web.multipart.MultipartFile;

public interface S3UploadProvider {


    S3File upload(MultipartFile file, DirectoryType type);

}
