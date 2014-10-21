package com.exactsix.mibaas.lecture.service.sqs;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.exactsix.mibaas.lecture.service.sqs.dto.FileDto;
import com.google.gson.Gson;

@Service
public class SqsService {

	private static String SQS_URL = "https://sqs.us-east-1.amazonaws.com/637614166593/";

	@Value("#{envProp['aws.amazon.key']}")
	private String accessKey;

	@Value("#{envProp['aws.amazon.secret']}")
	private String secretKey;

	private AWSCredentials credentials;

	private AmazonSQS client;

	private String sqsName = "xwmooc-sqs";

	@PostConstruct
	private void init() {
		credentials = new BasicAWSCredentials(accessKey, secretKey);
		client = new AmazonSQSClient(credentials);
		Region REGION = Region.getRegion(Regions.US_EAST_1);
		client.setRegion(REGION);
	}

	public void sendUpload(String name) {

		FileDto fileDto = new FileDto();
		fileDto.setFilename(name);

		Gson gson = new Gson();
		String json = gson.toJson(fileDto);

		sendSqs(json);

	}

	private void sendSqs(String json) {
		try {
			// Create a queue
			String myQueueUrl = SQS_URL + sqsName;
			client.sendMessage(new SendMessageRequest(myQueueUrl, json));

		} catch (AmazonServiceException ase) {

			System.out.println(ase.getMessage());
		} catch (AmazonClientException ace) {
			System.out.println(ace.getMessage());
		}
	}
}
