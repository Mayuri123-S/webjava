package com.sunbeam.services;
import com.sunbeam.*;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sunbeam.pojos.Mobile;
import com.sunbeam.pojos.MobileForm;

public interface MobileService {
	Mobile getMobileById(int mobileId);
	List<Mobile> getAllMobiles();
	int addMobile(MobileForm mf);
	void saveImage(MultipartFile file);
	int addMobile(Mobile mf);
}
