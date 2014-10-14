package com.exactsix.mibaas.email.service;

import org.springframework.stereotype.Service;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.exactsix.mibaas.common.response.RestResponse;

@Service
public class EmailService {

	static final String FROM = "dave.han1002@gmail.com";
	static final String TO = "jshan@osci.kr";

	static final String BODY = "This email was sent through Amazon SES by using the AWS SDK for Java.";
	static final String SUBJECT = "Amazon SES test (AWS SDK for Java)";

	public RestResponse sendMail() {

		RestResponse response = new RestResponse();

		Destination destination = new Destination()
				.withToAddresses(new String[] { TO });
		// Create the subject and body of the message.
		Content subject = new Content().withData(SUBJECT);
		Content textBody = new Content().withData(BODY);
		Body body = new Body().withText(textBody);

		// Create a message with the specified subject and body.
		Message message = new Message().withSubject(subject).withBody(body);

		// Assemble the email.
		SendEmailRequest request = new SendEmailRequest().withSource(FROM)
				.withDestination(destination).withMessage(message);

		try {

			AmazonSimpleEmailServiceClient client = new AmazonSimpleEmailServiceClient();

			Region REGION = Region.getRegion(Regions.US_EAST_1);
			client.setRegion(REGION);

			
			AWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
			AmazonSimpleEmailServiceClient sesClient = new AmazonSimpleEmailServiceClient(credentials);
			SendEmailResult result = sesClient.sendEmail(request);

			
			// Send the email.
			client.sendEmail(request);
			System.out.println("Email sent!");
		} catch (Exception ex) {
			System.out.println("The email was not sent.");
			System.out.println("Error message: " + ex.getMessage());
		}

		return response;
	}

}
