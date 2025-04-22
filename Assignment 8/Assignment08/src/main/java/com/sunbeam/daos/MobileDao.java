package com.sunbeam.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Mobile;

public interface MobileDao extends JpaRepository<Mobile, Integer> {
	List<Mobile> findByCompany(String company);
}

