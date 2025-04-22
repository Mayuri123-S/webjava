package com.sunbeam.controllers;

import java.io.File;
import java.io.FileInputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class FileController {
	@Value("${imagesFolderPath}")
	private String imageFolderPath;

	@GetMapping("/images/{imageName}")
	public void downloadImage(@PathVariable("imageName") String imgName, HttpServletResponse resp) throws Exception {
		String filePath = imageFolderPath + "/" + imgName;
		try(FileInputStream fin = new FileInputStream(filePath)) {
			FileCopyUtils.copy(fin, resp.getOutputStream());
		}
	}
}
