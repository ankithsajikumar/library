package com.library.entespotify.utils;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3Utils {
    @Bean
    public AmazonS3 s3() {
        AWSCredentials awsCredentials =
                new BasicAWSCredentials("392D49E8E376C9907168", "5WKeNXdCfhz2TYjZeUHcvVYwG9S4o7Q3rzUYXcoa");
        return AmazonS3ClientBuilder
                .standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("https://s3.filebase.com", null))
//                .withRegion("ap-south-1")
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }
}