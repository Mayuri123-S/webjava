package com.sunbeam.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sunbeam.daos.MobileDao;
import com.sunbeam.entities.Mobile;

@CrossOrigin
@RequestMapping("/mobiles")
@RestController
public class MobileRestController {
	@Autowired
	private MobileDao mobileDao;

	@GetMapping
	public ResponseUtil<?> findAllMobiles() {
		List<Mobile> list = mobileDao.findAll();
		return ResponseUtil.apiSuccess(list);
	}

	@GetMapping("/{id}")
	public ResponseUtil<?> findMobileById(@PathVariable("id") int mobileId) {
		Optional<Mobile> om = mobileDao.findById(mobileId);
		if (om.isPresent())
			return ResponseUtil.apiSuccess(om.get());
		else
			throw new RuntimeException("Mobile with ID " + mobileId + " not found.");
	}

	@GetMapping("/bycompany/{company}")
	public ResponseUtil<?> findCompanyMobiles(@PathVariable("company") String company) {
		List<Mobile> list = mobileDao.findByCompany(company);
		return ResponseUtil.apiSuccess(list);
	}

	@PostMapping
	public ResponseUtil<?> saveMobile(@RequestBody Mobile mobile) {
		Mobile saved = mobileDao.save(mobile);
		return ResponseUtil.apiSuccess(saved);
	}

	@PutMapping("/{id}")
	public ResponseUtil<?> updateMobile(@PathVariable("id") int id, @RequestBody Mobile mobile) {
		Optional<Mobile> om = mobileDao.findById(id);
		if (!om.isPresent())
			throw new RuntimeException("Mobile with ID " + id + " not found.");

		mobile.setId(id);
		Mobile updated = mobileDao.save(mobile);
		return ResponseUtil.apiSuccess(updated);
	}

	@DeleteMapping("/{id}")
	public ResponseUtil<?> deleteMobile(@PathVariable("id") int id) {
		if (!mobileDao.existsById(id))
			throw new RuntimeException("Mobile with ID " + id + " not found.");
		
		mobileDao.deleteById(id);
		return ResponseUtil.apiSuccess("Mobile deleted successfully.");
	}

	@PatchMapping("/{id}/price/{newPrice}")
	public ResponseUtil<?> updateMobilePrice(@PathVariable("id") int id, @PathVariable("newPrice") double newPrice) {
		Optional<Mobile> om = mobileDao.findById(id);
		if (!om.isPresent())
			throw new RuntimeException("Mobile with ID " + id + " not found.");
		
		Mobile mobile = om.get();
		mobile.setPrice(newPrice);
		Mobile updated = mobileDao.save(mobile);
		return ResponseUtil.apiSuccess(updated);
	}
}
