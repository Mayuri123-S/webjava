package com.sunbeam.controllers;

@CrossOrigin
@RequestMapping("/users")
@RestController
public class UserRestController {
	@Autowired private UserDao userDao;

	@PostMapping("/register")
	public ResponseUtil<?> register(@RequestBody User user) {
		User saved = userDao.save(user);
		return ResponseUtil.apiSuccess(saved);
	}

	@PostMapping("/login")
	public ResponseUtil<?> login(@RequestBody User loginUser) {
		Optional<User> opt = userDao.findByEmailAndPassword(loginUser.getEmail(), loginUser.getPassword());
		if(opt.isPresent())
			return ResponseUtil.apiSuccess(opt.get());
		else
			return ResponseUtil.apiError("Invalid credentials");
	}
}
