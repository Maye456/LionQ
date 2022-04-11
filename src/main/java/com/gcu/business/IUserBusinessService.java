package com.gcu.business;

import java.util.List;

import com.gcu.model.PostModel;
import com.gcu.model.UserModel;

public interface IUserBusinessService 
{
	/**
	 * Create a User
	 * @param newUser
	 * @return the new user created
	 */
	public int createUser(UserModel newUser);
	
	/**
	 * Get List of Users
	 * @return a list of users in database
	 */
	public List<UserModel> getUsers();
	
	/**
	 * Get List of Users with searchTerm
	 * @param searchTerm
	 * @return a list of users in database based on the searchTerm
	 */
	public List<UserModel> searchUsers(String searchTerm);
	
	/**
	 * Delete User By ID
	 * @param id
	 * @return deletes a user by its id
	 */
	public boolean deleteOne(long id);
	
	/**
	 * Update User By ID
	 * @param idToUpdate
	 * @param updateUser
	 * @return updates a user by its id 
	 */
	public UserModel updateOne(long idToUpdate, UserModel updateUser);
	
	/**
	 * Get User By ID
	 * @param Id
	 * @return user by its id
	 */
	public UserModel getById(int Id);
}
