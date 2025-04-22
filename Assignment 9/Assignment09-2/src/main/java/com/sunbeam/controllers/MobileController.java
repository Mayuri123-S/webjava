package com.sunbeam.controllers;

import com.sunbeam.daos.MobileDao;
import com.sunbeam.entities.Mobile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mobiles")
@CrossOrigin
public class MobileController {
	@Autowired
	private MobileDao mobileDao;

	@GetMapping
	public List<Mobile> findAll() {
		return mobileDao.findAll();
	}

	@GetMapping("/{id}")
	public Mobile findById(@PathVariable int id) {
		return mobileDao.findById(id).orElse(null);
	}

	@GetMapping("/company/{company}")
	public List<Mobile> findByCompany(@PathVariable String company) {
		return mobileDao.findByCompany(company);
	}

	@PostMapping
	public Mobile save(@RequestBody Mobile m) {
		return mobileDao.save(m);
	}

	@PutMapping
	public Mobile update(@RequestBody Mobile m) {
		return mobileDao.save(m);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		mobileDao.deleteById(id);
	}
}
