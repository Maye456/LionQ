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
import com.gcu.model.PostEntity;
import com.gcu.model.PostModel;
import com.gcu.model.UserEntity;

@Service
public class UserBusinessService implements UserDetailsService 
{

	@Autowired
	private UserDataServiceForRepository service;
	
	public UserBusinessService() {}

	public UserBusinessService(UserDataServiceForRepository service)
	{
		this.service = service;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		// Try to find the User in the database
		UserEntity user = service.findByUsername(username);
		
		if (user != null)
		{
			//Add roles, then return User object
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("USER"));
            return new User(user.getUsername(), user.getPassword(), authorities);
		}
		else
		{
			System.out.println("User not found");
			throw new UsernameNotFoundException("username not found");
		}
	}
	
	public UserModel getCurrentUser()
	{
		return new UserModel(service.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
	}
	
	public UserModel getUser(int Id)
	{
		UserEntity result = service.getByID(Id);
		UserModel user = new UserModel(
				result.getId(),
				result.getFirstName(),
				result.getLastName(),
				result.getEmail(),
				result.getUsername(),
				result.getPassword(),
				result.getRole()
				);
		return user;
	}
}
