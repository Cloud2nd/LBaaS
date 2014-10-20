package com.exactsix.mibaas.file;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

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

	public RestResponse fileSave(MultipartFile file) {

		RestResponse response = new RestResponse();

		String fileName = null;
		if (!file.isEmpty()) {
			try {
				fileName = file.getOriginalFilename();

				System.out.println(file.getContentType());

				byte[] bytes = file.getBytes();
				BufferedOutputStream buffStream = new BufferedOutputStream(
						new FileOutputStream(new File("/home/data/" + fileName)));
				buffStream.write(bytes);
				buffStream.close();
				response.setStatus(true);
				FileDto fileDto = new FileDto();
				fileDto.setFilename(fileName);

				response.setData(fileDto);

			} catch (Exception e) {
				response.setStatus(false);
			}
		} else {
			response.setStatus(false);
		}

		return response;
	}

}
