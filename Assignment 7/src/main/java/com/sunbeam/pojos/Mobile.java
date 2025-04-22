package com.sunbeam.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Mobile {
	private int id;
	private String name;
	private int ram;
	private int storage;
	private String company;
	private double price;
	private String image;
}
