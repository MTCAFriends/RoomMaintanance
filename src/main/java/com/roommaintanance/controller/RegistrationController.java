package com.roommaintanance.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.roommaintanance.model.AppUser;
import com.roommaintanance.service.UserDeatilsService;

@Controller
public class RegistrationController {
	@Autowired
	private UserDeatilsService userDeatilsService;
	

    @RequestMapping(value="/user",method = RequestMethod.POST)
    public ResponseEntity ProcessUser(@RequestBody AppUser userDetails)
    {
    	System.out.println(userDetails.toString());
        return new ResponseEntity(HttpStatus.OK);
    }
	
		@RequestMapping(value = "/upload", method = RequestMethod.POST )
	       public String  uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
			userDeatilsService.saveUserDetails(file);
     	         return "fileUploadForm";
	       }
		/*@RequestMapping(value = "/upload", method = RequestMethod.POST )
		public JSONObject saveUserDetails() {
			
		}*/
		
		
		/*
		@RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)
		  public void showImage(HttpServletResponse response,HttpServletRequest request)
		          throws ServletException, IOException{
			HttpSession session=request.getSession();
			Long userId=(Long) session.getAttribute("user_id");
			UserProfilePicEntity doc = userProfilePicStorageDAO.getByUserPictureId(userId);
			if(doc!=null){
				Blob blob = doc.getContent();
		        int blobLength = 0;
		        byte[] blobAsBytes = null;
				try {
					blobLength = (int) blob.length();
				} catch (SQLException exception) {
					exception.printStackTrace();
				}
		        try {
					blobAsBytes = blob.getBytes(1, blobLength);
				} catch (SQLException exception) {
					exception.printStackTrace();
				}
		        //release the blob and free up memory. (since JDBC 4.0)
		        try {
					blob.free();
				} catch (SQLException exception) {
					exception.printStackTrace();
				}
		    response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		    response.getOutputStream().write(blobAsBytes);

		    response.getOutputStream().close();
			}*/
}
