package com.project.robotmate.admin.global.aws.util;
import com.project.robotmate.admin.global.aws.model.FileType;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
public class AwsUtil {
    @Value("${cloud.aws.s3.bucket-url}")
    private static String IMAGE_URL;

    public static String conventUrl(String bucket) {
        if (bucket == null) {
            return null;
        }
        return IMAGE_URL.concat("/").concat(bucket);
    }
    public static String createFilename(String dir) {
        return dir + UUID.randomUUID().toString().replace("-", "");
    }
    public static boolean isAllowExtension(String originalFilename, FileType type) {
        switch (type) {
            case ALL:
                break;
            case IMAGE:
                return FilenameUtils.isExtension(originalFilename, Arrays.asList("jpg","jpeg","png","svg","webp","gif"));
            case VIDEO:
                return FilenameUtils.isExtension(originalFilename, Arrays.asList("mp4","avi","wmv"));
            case WAV:
                return FilenameUtils.isExtension(originalFilename, "wav");
            case PDF :
                return FilenameUtils.isExtension(originalFilename, "pdf");
            case HWP :
                return FilenameUtils.isExtension(originalFilename, "hwp");
            case EXCEL:
                return FilenameUtils.isExtension(originalFilename, Arrays.asList("xls","xlsx","xlsm"));
            case PPT:
                return FilenameUtils.isExtension(originalFilename, Arrays.asList("ppt","pptx","pptm"));
            case WORD:
                return FilenameUtils.isExtension(originalFilename, Arrays.asList("doc","docx"));
            case TXT:
                return FilenameUtils.isExtension(originalFilename, "txt");
            case ZIP:
                return FilenameUtils.isExtension(originalFilename, Arrays.asList("zip","egg"));
        }
        return true;
    }

    public static boolean isAllowExtension(String originalFilename, List<FileType> types) {
        return types.stream().anyMatch( t -> isAllowExtension(originalFilename, t) );
    }

}
