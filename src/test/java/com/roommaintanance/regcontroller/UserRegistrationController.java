package com.roommaintanance.regcontroller;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.roommaintanance.config.AppConfig;
import com.roommaintanance.model.AppUser;
import com.roommaintanance.model.AppUserRole;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class})
@WebAppConfiguration
public class UserRegistrationController {
	
	 private MockMvc mockMvc;

	    @Autowired
	    private WebApplicationContext wac;
	    @Before
	    public void setup() {
	    	mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	    }
	  /*  @Before
	    public void setUp() {
	        mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	    }*/
	    @Test
	    public void testCreationOfANewProjectSucceeds() throws Exception {
	    	AppUser appUser = new AppUser();
	    	appUser.setAppUserEmailID("Subbu@gmail.com");
	    	appUser.setAppUserName("subbu");
	    	appUser.setAppUserPassword("subbu");
	    	appUser.setAppUserRoles(new HashSet<AppUserRole>());
	        String json = new Gson().toJson(appUser);
	        mockMvc.perform(post("/user").
	        		accept(MediaType.APPLICATION_JSON)
	        		.contentType(MediaType.APPLICATION_JSON)
	        		.content(json)
	        		).andExpect(status().isCreated());
	      /*  mockMvc.perform(
	                post("/user")
	                        .accept(MediaType.APPLICATION_JSON)
	                        .contentType(MediaType.APPLICATION_JSON)
	                        .content(json))
	                .andExpect(status().isCreated());*/
	    }
	    
	    public String getJsonData(Object object) throws JsonProcessingException {
	    	ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	    	String json = ow.writeValueAsString(object);
	    	return json;
	    	
	    }
	    



}
