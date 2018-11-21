package com.roommaintanance.dao;

import com.roommaintanance.model.AppUser;

public interface UserDao {

	AppUser findById(int id);

	AppUser findByUserName(String userName);

	void saveUserDetails(UploadFile uploadFile);

}
