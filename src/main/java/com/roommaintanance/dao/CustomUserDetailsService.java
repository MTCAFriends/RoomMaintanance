package com.roommaintanance.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.roommaintanance.model.AppUser;
import com.roommaintanance.model.AppUserRole;
import com.roommaintanance.service.UserDeatilsService;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserDeatilsService userDeatilsService;

	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		AppUser user = userDeatilsService.findByUserName(userName);
        System.out.println("User : "+user);
        if(user==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
            return new org.springframework.security.core.userdetails.User(user.getAppUserName(), user.getAppUserPassword(), 
                 true, true, true, true, getGrantedAuthorities(user));
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(AppUser user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
         
        for(AppUserRole userProfile : user.getAppUserRoles()){
            System.out.println("UserProfile : "+userProfile);
            authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getRoleName()));
        }
        System.out.print("authorities :"+authorities);
        return authorities;
    }

}
