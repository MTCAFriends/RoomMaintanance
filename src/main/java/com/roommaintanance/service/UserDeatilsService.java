package com.roommaintanance.service;

import org.springframework.web.multipart.MultipartFile;

import com.roommaintanance.model.AppUser;

public interface UserDeatilsService {
	AppUser findById(int id);
	AppUser findByUserName(String userName);
	void saveUserDetails(MultipartFile file);

}
