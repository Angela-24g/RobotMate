package cloud.aws.s3.util;

import cloud.aws.s3.config.AwsS3BucketProvider;

public class S3UrlUtil {

    private static String IMAGE_URL;

    public void setImageUrl(String bucketUrl) {
        IMAGE_URL =bucketUrl;
    }

    public static String conventUrl(String bucket) {
        if (bucket == null) {
            return null;
        }
        return IMAGE_URL.concat("/").concat(bucket);
    }
}
