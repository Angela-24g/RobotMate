package cloud.aws.s3.config;

import cloud.aws.s3.config.properties.AwsS3BucketProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(AwsS3BucketProperties.class)
public class AwsS3BucketAutoConfiguration {

    @Bean
    public AwsS3BucketProvider awsS3BucketProvider(AwsS3BucketProperties properties) {
        return new DefaultAwsS3BucketProvider(properties.getBucket(), properties.getBucketUrl());
    }
}
