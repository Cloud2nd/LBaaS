package com.exactsix.mibaas.file;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.jets3t.service.S3Service;
import org.jets3t.service.S3ServiceException;
import org.jets3t.service.impl.rest.httpclient.RestS3Service;
import org.jets3t.service.model.S3Object;
import org.jets3t.service.security.AWSCredentials;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.exactsix.mibaas.common.response.RestResponse;
import com.exactsix.mibaas.file.dto.FileDto;

/**
 * <pre>
 * Class Name  : FileService.java
 * Description :
 * Modification Information
 * 
 * </pre>
 * 
 * @author dave
 * @since 2014. 9. 16.
 * @version 1.0
 * 
 */
@Service
public class FileService {

	@Value("#{envProp['aws.amazon.key']}")
	private String awsAccessKey;

	@Value("#{envProp['aws.amazon.secret']}")
	private String awsSecretKey;

	@Value("#{envProp['aws.amazon.bucketname']}")
	private String bucketName;

	private AWSCredentials awsCredentials;

	private S3Service s3Service;

	@PostConstruct
	private void init() {
		awsCredentials = new AWSCredentials(awsAccessKey, awsSecretKey);
		s3Service = new RestS3Service(awsCredentials);
	}

	public RestResponse fileSave(MultipartFile file) {

		RestResponse response = new RestResponse();

		String fileName = null;
		if (!file.isEmpty()) {
			try {
				fileName = file.getOriginalFilename();

				String origin = fileName;
				String uuid = getUUID();
				String extension = getExtensionFileName(origin);
				String replaceFileName = uuid + "." + extension;

				byte[] bytes = file.getBytes();
				BufferedOutputStream buffStream = new BufferedOutputStream(
						new FileOutputStream(new File("/home/data/" + replaceFileName)));
				
				/*BufferedOutputStream buffStream = new BufferedOutputStream(
						new FileOutputStream(new File("C:/develop/temp/" + replaceFileName)));*/
				buffStream.write(bytes);
				buffStream.close();

				String type = file.getContentType();
				int size = (int) file.getSize();

				response.setStatus(true);
				FileDto fileDto = new FileDto();
				fileDto.setFilename(replaceFileName);
				fileDto.setOriginNmae(fileName);

				// uploadS3(fileName);

				response.setData(fileDto);

			} catch (Exception e) {
				response.setStatus(false);
			}
		} else {
			response.setStatus(false);
		}

		return response;
	}

	private void uploadS3(String fileName) {

		File fileData = new File("/home/data/" + fileName);
		try {

			S3Object fileObject = new S3Object(fileData);
			s3Service.putObject(bucketName, fileObject);

		} catch (NoSuchAlgorithmException | IOException | S3ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String getSignedUrl() {

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, 15);
		Date expiryDate = cal.getTime();

		String signedUrl = s3Service.createSignedGetUrl("", "", expiryDate,
				false);

		return signedUrl;

	}

	public String getUUID() {
		return UUID.randomUUID().toString();
	}

	private String getExtensionFileName(String fileName) {

		String extension = "";

		int fileIndex = fileName.lastIndexOf('.');

		// 파일명과 확장자를 분리
		if (fileIndex != -1) {
			extension = fileName.substring(fileIndex + 1);
		}

		return extension;
	}
}
