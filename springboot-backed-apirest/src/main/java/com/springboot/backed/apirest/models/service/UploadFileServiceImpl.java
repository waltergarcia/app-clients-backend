package com.springboot.backed.apirest.models.service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.backed.apirest.models.service.interfaces.IUploadFileService;

@Service
public class UploadFileServiceImpl implements IUploadFileService{

	private final Logger logger = LoggerFactory.getLogger(UploadFileServiceImpl.class);
	
	private final static String DIR_PHOTOS = "imageUploads";
	
	@Override
	public Resource load(String namePhoto) throws MalformedURLException {
		Resource resource = null;
		Path dirFile = getPath(namePhoto);
		
		logger.info(dirFile.toString());
		
		resource = new UrlResource(dirFile.toUri());

		if(!resource.exists() && !resource.isReadable()) {
			dirFile = Paths.get("src/main/resources/static/images").resolve("no_user.png").toAbsolutePath();
			resource = new UrlResource(dirFile.toUri());
			logger.info("Error loading client image: " + namePhoto);
		}
		
		return resource;
	}

	@Override
	public String copy(MultipartFile file) throws IOException {
		String nameFile = UUID.randomUUID().toString() + "_" + file.getOriginalFilename().replace(" ", "");
		Path dirFile = getPath(nameFile);
		
		logger.info(dirFile.toString());
		
		Files.copy(file.getInputStream(), dirFile);
	
		return nameFile;
	}

	@Override
	public boolean delete(String namePhoto) {		
		if(namePhoto != null && namePhoto.length() > 0) {
			Path dirOldFile = Paths.get("imageUploads").resolve(namePhoto).toAbsolutePath();
			File oldFile = dirOldFile.toFile();
			if(oldFile.exists() && oldFile.canRead()) {
				oldFile.delete();
				return true;
			}
		}
		return false;
	}

	@Override
	public Path getPath(String namePhoto) {
		return Paths.get(DIR_PHOTOS).resolve(namePhoto).toAbsolutePath();
	}
}
