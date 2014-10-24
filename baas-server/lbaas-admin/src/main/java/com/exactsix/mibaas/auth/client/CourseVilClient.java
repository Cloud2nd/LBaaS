package com.exactsix.mibaas.auth.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CourseVilClient {

	static RestTemplate restTemplate = new RestTemplate();

	public UserResponse login(UserLogin login) {

		try {
			String url = "http://auth.coursevil.org/api/usermanagement/login";

			HttpHeaders requestHeaders = new HttpHeaders();

			List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
			acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
			requestHeaders.setAccept(acceptableMediaTypes);
			requestHeaders.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<UserLogin> requestEntity = new HttpEntity<UserLogin>(
					login, requestHeaders);

			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getMessageConverters().add(
					new MappingJackson2HttpMessageConverter());
			restTemplate.getMessageConverters().add(
					new StringHttpMessageConverter());

			ResponseEntity<UserResponse> responseEntity = restTemplate
					.exchange(url, HttpMethod.POST, requestEntity,
							UserResponse.class);

			return responseEntity.getBody();
		} catch (Exception e) {
			// logger.debug("exception {}", e.getMessage());
			e.printStackTrace();
		}

		return null;
	}

}
