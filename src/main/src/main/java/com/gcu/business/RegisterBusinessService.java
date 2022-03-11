/*
 *	Jeanna Maye Benitez
 *	March 10, 2022
 *	Description: Executes CRUD operations with UserModel and UserEntity
 */

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

	@Override
	public boolean deleteOne(long id)
	{
		return service.deleteOne(id);
	}

	@Override
	public UserModel updateOne(long idToUpdate, UserModel updateUser)
	{
		UserEntity entity = new UserEntity(
				updateUser.getId(),
				updateUser.getFirstName(),
				updateUser.getLastName(),
				updateUser.getEmail(),
				updateUser.getUsername(),
				updateUser.getPassword(),
				updateUser.getRole()
                );
		UserEntity result = service.updateOne(idToUpdate, entity);
        
        UserModel updated = new UserModel(
        		result.getId(),
        		result.getFirstName(),
        		result.getLastName(),
        		result.getEmail(),
        		result.getUsername(),
        		result.getPassword(),
        		result.getRole()
                );
        return updated;
	}

	@Override
	public UserModel getById(int Id)
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