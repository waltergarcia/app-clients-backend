package com.springboot.backed.apirest.models.service.interfaces;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IUploadFileService {
	Resource load(String namePhoto) throws MalformedURLException;
	String copy(MultipartFile file) throws IOException;
	boolean delete(String namePhoto);
	Path getPath(String namePhoto);
}
