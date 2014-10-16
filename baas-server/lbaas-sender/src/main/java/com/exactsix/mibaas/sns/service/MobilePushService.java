package com.exactsix.mibaas.sns.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.CreatePlatformEndpointRequest;
import com.amazonaws.services.sns.model.CreatePlatformEndpointResult;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;

@Service
public class MobilePushService {

	@Value("#{envProp['aws.amazon.key']}")
	private String accessKey;

	@Value("#{envProp['aws.amazon.secret']}")
	private String secretKey;

	private AWSCredentials credentials;

	private AmazonSNSClient client;

	@PostConstruct
	private void init() {
		credentials = new BasicAWSCredentials(accessKey, secretKey);
		client = new AmazonSNSClient(credentials);
		Region REGION = Region.getRegion(Regions.US_EAST_1);
		client.setRegion(REGION);
	}
	
	public void regist(){
		
		//arn:aws:sns:us-east-1:637614166593:app/GCM/coursevil
		
		Map<String ,String> attributes = new HashMap<String ,String>();
		// Insert your UserId. This is a mandatory field.
		attributes.put("UserId", "9999999999");
		// Insert your ChannelId. This is a mandatory field.
		attributes.put("ChannelId", "1234567890");
		CreatePlatformEndpointRequest createPlatformEndpointRequest = new CreatePlatformEndpointRequest();

		
		createPlatformEndpointRequest.setAttributes(attributes);
		createPlatformEndpointRequest.setToken("1234567890");
		createPlatformEndpointRequest.setCustomUserData("Test Endpoint");
		createPlatformEndpointRequest.setPlatformApplicationArn("arn:aws:sns:us-east-1:637614166593:app/GCM/coursevil");
		CreatePlatformEndpointResult endpointArn = client.createPlatformEndpoint(createPlatformEndpointRequest);
		
		System.out.println(endpointArn.getEndpointArn());
		//client.getPlatformApplicationAttributes(getPlatformApplicationAttributesRequest)
	}
	
	public void send(){
		
		PublishRequest publishRequest = new PublishRequest();
		//publishRequest.setMessageAttributes(messageAttributes);
		String message = "test";
		publishRequest.setMessage(message);
		publishRequest.setTargetArn("arn:aws:sns:us-east-1:637614166593:endpoint/GCM/coursevil/493a0256-b4cb-3594-9675-bda02029ba43");
		PublishResult publishResult = client.publish(publishRequest);
		
		
	}
}
