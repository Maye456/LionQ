package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gcu.data.UserDataServiceForRepository;
import com.gcu.model.UserModel;
import com.gcu.model.PostEntity;
import com.gcu.model.PostModel;
import com.gcu.model.UserEntity;

@Service
public class RegisterBusinessService implements IUserBusinessService
{
	@Autowired
	private UserDataServiceForRepository service;

	@Override
	public int createUser(UserModel newUser) 
	{
		UserEntity entity = new UserEntity(
				newUser.getId(),
				newUser.getFirstName(),
				newUser.getLastName(),
				newUser.getEmail(),
				newUser.getUsername(),
				newUser.getPassword(),
				"USER"
                );
        return service.createUser(entity);
	}

	@Override
	public List<UserModel> getUsers()
	{
		// Fetch the list of entities
		List<UserEntity> usersE = service.getUsers();
		// Create an empty list of posts
		List<UserModel> users = new ArrayList<UserModel>();
		// For each entity in the list, create a new order and add to orders
		for (UserEntity entity: usersE)
		{
			users.add(
					// Translate from Entity to Post Model
					new UserModel(
							entity.getId(),
							entity.getFirstName(),
							entity.getLastName(),
							entity.getEmail(),
							entity.getUsername(),
							entity.getPassword(),
							entity.getRole())
					);
		}
		return users;
	}

	@Override
	public List<UserModel> searchUsers(String searchTerm)
	{
		List<UserEntity> usersE = service.searchUsers(searchTerm);
        List<UserModel> users = new ArrayList<UserModel>();
        for (UserEntity entity: usersE)
        {
        	users.add(
                    // Translate from Entity to Order Model
                    new UserModel(
                    		entity.getId(),
							entity.getFirstName(),
							entity.getLastName(),
							entity.getEmail(),
							entity.getUsername(),
							entity.getPassword(),
							entity.getRole())
                    );
        }
        return users;
	}	
}