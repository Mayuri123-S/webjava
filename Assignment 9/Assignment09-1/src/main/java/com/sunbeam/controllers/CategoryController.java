package com.sunbeam.controllers;

import com.sunbeam.daos.CategoryDao;
import com.sunbeam.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin
public class CategoryController {
	@Autowired
	private CategoryDao categoryDao;

	@GetMapping
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	@GetMapping("/{id}")
	public Category findById(@PathVariable int id) {
		return categoryDao.findById(id).orElse(null);
	}

	@PostMapping
	public Category save(@RequestBody Category c) {
		return categoryDao.save(c);
	}

	@PutMapping
	public Category update(@RequestBody Category c) {
		return categoryDao.save(c);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		categoryDao.deleteById(id);
	}
}
