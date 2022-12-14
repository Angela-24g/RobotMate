package cloud.aws.s3.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "cloud.aws.credentials")
public class AwsS3BucketProperties {

    private String bucket;

    private String bucketUrl;

    public String getBucket() {
        return bucket;
    }

    public String getBucketUrl() {
        return bucketUrl;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public void setBucketUrl(String bucketUrl) {
        this.bucketUrl = bucketUrl;
    }

}
