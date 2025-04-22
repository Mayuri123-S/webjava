package com.sunbeam.daos;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	Optional<User> findByEmail(String email);
	Optional<User> findByEmailAndPassword(String email, String password);
}
