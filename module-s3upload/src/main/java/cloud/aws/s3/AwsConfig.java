package cloud.aws.s3;

import cloud.aws.s3.config.AwsS3BucketProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration(proxyBeanMethods = false)
public class AwsConfig {

    @Bean
    @ConditionalOnBean(AmazonS3Client.class)
    public static AmazonS3Client amazonS3Client() {
        return (AmazonS3Client) AmazonS3ClientBuilder.standard()
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .build();
    }


    @Bean
    @ConditionalOnMissingBean
    public S3UploadProvider s3UploadProvider(AmazonS3Client amazonS3Client, AwsS3BucketProvider provider) {
        return new DefaultS3UploadProvider(amazonS3Client, provider);
    }

}
