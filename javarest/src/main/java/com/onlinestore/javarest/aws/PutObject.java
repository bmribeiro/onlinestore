package com.onlinestore.javarest.aws;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

@Component
public class PutObject {

	@Autowired
	private S3Client s3Client;

	public void putS3Object(String objectKey, String objectPath) {

		String bucketName = "onlinestorejavarest";

		try {
			Map<String, String> metadata = new HashMap<>();
			metadata.put("key", "value");
			PutObjectRequest putOb = PutObjectRequest.builder().bucket(bucketName).key(objectKey).metadata(metadata)
					.build();

			s3Client.putObject(putOb, RequestBody.fromFile(new File(objectPath)));
			System.out.println("Successfully placed " + objectKey + " into bucket " + bucketName);

		} catch (S3Exception e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
		s3Client.close();
	}
}