package com.sunbeam.controllers;

import com.sunbeam.daos.UserDao;
import com.sunbeam.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
	@Autowired
	private UserDao userDao;

	@GetMapping
	public List<User> findAll() {
		return userDao.findAll();
	}

	@GetMapping("/{id}")
	public User findById(@PathVariable int id) {
		return userDao.findById(id).orElse(null);
	}

	@PostMapping
	public User save(@RequestBody User u) {
		return userDao.save(u);
	}

	@PutMapping
	public User update(@RequestBody User u) {
		return userDao.save(u);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		userDao.deleteById(id);
	}

	@PostMapping("/login")
	public User login(@RequestBody User user) {
		return userDao.findByEmailAndPassword(user.getEmail(), user.getPassword()).orElse(null);
	}
}
