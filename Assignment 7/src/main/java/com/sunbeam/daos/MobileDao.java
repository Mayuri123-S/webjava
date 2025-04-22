package com.sunbeam.daos;

import java.util.List;

import com.sunbeam.pojos.Mobile;

public interface MobileDao {
	Mobile findById(int id);
	List<MobileDao> findADaos();
	int save(Mobile m);
	List<Mobile> findAll();
}
