package com.sunbeam.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class NewOrder {
	@JsonProperty("uid")
	private int userId;
	@JsonProperty("mid")
	private int mobileId;
}
