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
			return ResponseUtil.apiError("Mobile not found");
	}

	@GetMapping("/bycompany/{company}")
	public ResponseUtil<?> findCompanyMobiles(@PathVariable("company") String company) {
		List<Mobile> list = mobileDao.findByCompany(company);
		return ResponseUtil.apiSuccess(list);
	}

	// Homework

	@PostMapping
	public ResponseUtil<?> addMobile(@RequestBody Mobile m) {
		mobileDao.save(m);
		return ResponseUtil.apiSuccess("Mobile added successfully");
	}

	@PutMapping("/{id}")
	public ResponseUtil<?> updateMobile(@PathVariable("id") int id, @RequestBody Mobile m) {
		Optional<Mobile> om = mobileDao.findById(id);
		if (om.isPresent()) {
			m.setId(id);
			mobileDao.save(m);
			return ResponseUtil.apiSuccess("Mobile updated successfully");
		} else {
			return ResponseUtil.apiError("Mobile not found");
		}
	}

	@DeleteMapping("/{id}")
	public ResponseUtil<?> deleteMobile(@PathVariable("id") int id) {
		Optional<Mobile> om = mobileDao.findById(id);
		if (om.isPresent()) {
			mobileDao.deleteById(id);
			return ResponseUtil.apiSuccess("Mobile deleted successfully");
		} else {
			return ResponseUtil.apiError("Mobile not found");
		}
	}

	@PatchMapping("/{id}/price")
	public ResponseUtil<?> updatePrice(@PathVariable("id") int id, @RequestBody Mobile m) {
		Optional<Mobile> om = mobileDao.findById(id);
		if (om.isPresent()) {
			Mobile existing = om.get();
			existing.setPrice(m.getPrice());
			mobileDao.save(existing);
			return ResponseUtil.apiSuccess("Price updated successfully");
		} else {
			return ResponseUtil.apiError("Mobile not found");
		}
	}
}
