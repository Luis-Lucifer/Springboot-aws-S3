package service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.S3Utilities;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;


public class S3Service {


    @Value("${aws.s3.bucketName}")
    private static String bucketName;

    public static String uploadResume(String fileName, MultipartFile resume) throws IOException {

    S3Client s3Client = S3Client.builder().region(Region.AP_SOUTH_1).
            credentialsProvider(DefaultCredentialsProvider.create()).build();

    String key = "resume/" + resume.getOriginalFilename();

        PutObjectRequest putObjectRequest = PutObjectRequest.builder().bucket(bucketName).key(key)
                .contentType(resume.getContentType())
                .build();

        s3Client.putObject(putObjectRequest, RequestBody.fromBytes(resume.getBytes()));
        S3Utilities s3Utilities = s3Client.utilities();

        String resumeUrl = s3Utilities.getUrl(builder -> builder.bucket(bucketName).key(key)).toExternalForm();

        return resumeUrl;

//        S3Client s3Client = S3Client.builder().
//                region(ap-south-1).
//                credentialsProvider(DefaultCredentialsProvider.create())
    }
}
