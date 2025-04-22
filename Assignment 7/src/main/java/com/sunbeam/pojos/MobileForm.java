package com.sunbeam.pojos;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class MobileForm {
	private String name;
	private int ram;
	private int storage;
	private String company;
	private double price;
	private MultipartFile image;
}
