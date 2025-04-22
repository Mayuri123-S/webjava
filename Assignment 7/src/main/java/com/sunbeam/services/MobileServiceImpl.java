package com.sunbeam.services;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sunbeam.daos.MobileDao;
import com.sunbeam.pojos.Mobile;
import com.sunbeam.pojos.MobileForm;

@Service
public class MobileServiceImpl implements MobileService {
	@Autowired
	private MobileDao mobileDao;

	public Mobile getMobileById(int mobileId) {
		Mobile m = mobileDao.findById(mobileId);
		return m;
	}
	
	@Override
	public List<Mobile> getAllMobiles() {
		List<Mobile> list = mobileDao.findAll();
		return list;
	}
	
	@Override
	public int addMobile(Mobile mf) {
		String imageName = mf.getImage().getOriginalFilename();
		Mobile m = new Mobile(0, mf.getName(), mf.getRam(), mf.getStorage(), mf.getCompany(), mf.getPrice(), imageName);
		saveImage(mf.getImage());
		int count = mobileDao.save(m);
		return count;
	}
	
	@Value("${imagesFolderPath}")
	private String imageFolderPath;
	
	@Override
	public void saveImage(MultipartFile file) {
		String filePath = imageFolderPath + "/" + file.getOriginalFilename();
		try(FileOutputStream fout = new FileOutputStream(filePath)) {
			FileCopyUtils.copy(file.getInputStream(), fout);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
