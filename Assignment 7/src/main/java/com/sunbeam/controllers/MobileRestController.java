package com.sunbeam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.pojos.Mobile;
import com.sunbeam.pojos.MobileForm;
import com.sunbeam.services.MobileService;

@RequestMapping("/mobiles")
@RestController
public class MobileRestController {
	@Autowired
	private MobileService mobileService;
	
	@GetMapping("/{id}")
	public ResponseUtil<?> getMobileById(@PathVariable("id") int mobileId) {
		Mobile m = mobileService.getMobileById(mobileId);
		if(m != null)
			return ResponseUtil.apiSuccess(m);
		return ResponseUtil.apiError("Mobile not found");
	}
	
	@GetMapping("")
	public ResponseUtil<?> getAllMobiles() {
		List<Mobile> list = mobileService.getAllMobiles();
		return ResponseUtil.apiSuccess(list);
	}
	
	@PostMapping("")
	public ResponseUtil<?> addMobile(MobileForm mf) {
		mobileService.addMobile(mf);
		return ResponseUtil.apiSuccess("Mobile added");
	}
}
