package com.project.robotmate.admin.global.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class S3UrlUtil {
    @Value("${cloud.aws.credentials.bucket-url}")
    private static String IMAGE_URL;

    public static String conventUrl(String bucket) {
        if (bucket == null) {
            return null;
        }
        return IMAGE_URL.concat("/").concat(bucket);
    }
}
