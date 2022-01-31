package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.gcu.data.UserDataServiceForRepository;
import com.gcu.model.UserModel;
import com.gcu.model.PostModel;
import com.gcu.model.UserEntity;

@Service
public class UserBusinessService implements UserDetailsService 
{

	@Autowired
	private UserDataServiceForRepository service;

	public UserBusinessService(UserDataServiceForRepository service)
	{
		this.service = service;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		System.out.println("User Business Service is searching for " + username);
		
		// Try to find the User in the database
		UserEntity user = service.findByUsername(username);
		
		if (user != null)
		{
			//Add roles, then return User object
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("USER"));
            return new User(user.getUsername(), user.getPassword(), authorities);
            
//			System.out.println(user.getUsername());
//			
//			// Add authorities associated with user
//			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//			System.out.println("Role ============ " + user.getRole());
//			authorities.add(new SimpleGrantedAuthority(user.getRole()));
//			
//			// Admin allowed to access all pages
//			if (user.getRole().equals("ADMIN"))
//			{
//				authorities.add(new SimpleGrantedAuthority("USER"));
//			}
//			
//			// Test to make sure it works
//			System.out.println("Authorities ======= " + authorities.get(0) + " " + authorities);
//			User newUser = new User(user.getUsername(), user.getPassword(), authorities);
//			System.out.println("The user created w/ UserDetails service in BS " + newUser);
//			return newUser;
		}
		else
		{
			System.out.println("User not found");
			throw new UsernameNotFoundException("username not found");
		}
	}
	
	public UserModel getCurrentUser()
	{
		System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
		return new UserModel(service.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
	}
}
