package com.sunbeam.pojos;

import org.apache.catalina.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class OrderInfo {
	private int id; // order id
	private User user;
	private Mobile mobile;
}
