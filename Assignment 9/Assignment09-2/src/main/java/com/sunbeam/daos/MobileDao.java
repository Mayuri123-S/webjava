package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sunbeam.entities.Mobile;

import java.util.List;

public interface MobileDao extends JpaRepository<Mobile, Integer> {
	List<Mobile> findByCompany(String company);
}
