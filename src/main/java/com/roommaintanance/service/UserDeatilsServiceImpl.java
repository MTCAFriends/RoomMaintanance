package com.roommaintanance.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.roommaintanance.dao.UploadFile;
import com.roommaintanance.dao.UserDao;
import com.roommaintanance.model.AppUser;

@Service
@Transactional
public class UserDeatilsServiceImpl implements UserDeatilsService{
	
	@Autowired
	private UserDao userDao;

	public AppUser findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public AppUser findByUserName(String userName) {
		return userDao.findByUserName(userName);
	}

	public void saveUserDetails(MultipartFile file) {
		// TODO Auto-generated method stub
		UploadFile uploadFile = new UploadFile();
        uploadFile.setFileName(file.getOriginalFilename());
        try {
			uploadFile.setData(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        userDao.saveUserDetails(uploadFile);  
		
	}

}
