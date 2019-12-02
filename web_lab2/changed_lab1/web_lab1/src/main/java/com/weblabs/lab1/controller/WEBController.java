package com.weblabs.lab1.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WEBController {

	@RequestMapping(method = RequestMethod.GET, value = "/info")
	public String getHelloPage()
	{  
		return "info.html";
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/image")
	public ResponseEntity<byte[]>  getImagePage()
	{
		byte[] imageContent = getImage();
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageContent);
	}
	
	public byte[] getImage() {
		File file = new File("src/main/resources/static/image.jpg");
		byte[] fileContext = null;
		
		try {
			fileContext = Files.readAllBytes(file.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return fileContext;
	}

}
