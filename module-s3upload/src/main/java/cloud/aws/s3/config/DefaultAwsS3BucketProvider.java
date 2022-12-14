package cloud.aws.s3.config;

import org.springframework.util.Assert;

public class DefaultAwsS3BucketProvider implements AwsS3BucketProvider {

    private final String bucket;

    private final String bucketUrl;

    public DefaultAwsS3BucketProvider(String bucket, String bucketUrl) {
        Assert.state(bucket != null, "Bucket must not be null");
        Assert.state(bucketUrl != null, "BucketUrl must not be null");
        this.bucket = bucket;
        this.bucketUrl = bucketUrl;
    }

    @Override
    public String getBucket() {
        return this.bucket;
    }

    @Override
    public String getBucketUrl() {
        return this.bucketUrl;
    }

}
