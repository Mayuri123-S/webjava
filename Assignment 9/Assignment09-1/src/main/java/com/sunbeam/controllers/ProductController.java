package com.sunbeam.controllers;

import com.sunbeam.daos.ProductDao;
import com.sunbeam.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {
	@Autowired
	private ProductDao productDao;

	@GetMapping
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@GetMapping("/{id}")
	public Product findById(@PathVariable int id) {
		return productDao.findById(id).orElse(null);
	}

	@PostMapping
	public Product save(@RequestBody Product p) {
		return productDao.save(p);
	}

	@PutMapping
	public Product update(@RequestBody Product p) {
		return productDao.save(p);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		productDao.deleteById(id);
	}
}
