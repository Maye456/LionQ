package com.gcu.data;

import java.util.List;

import org.springframework.stereotype.Service;

public interface IUserDataAccess<T>
{ 
	/**
	 * Create a User
	 * @param newUser
	 * @return the new user created
	 */
	public int createUser(T newUser);
	
	/**
	 * Get a User By Username
	 * @param username
	 * @return a user 
	 */
	public T findByUsername(String username);
	
	/**
	 * Get List of Users
	 * @return a list of users in database
	 */
	public List<T> getUsers();
	
	/**
	 * Get List of Users with searchTerm
	 * @param searchTerm
	 * @return a list of users in database based on the searchTerm
	 */
	public List<T> searchUsers(String searchTerm);
	
	/**
	 * Delete User By ID
	 * @param id
	 * @return deletes a user by its id
	 */
	public boolean deleteOne(long id);
	
	/**
	 * Get User By ID
	 * @param Id
	 * @return user by its id
	 */
	public T getByID(int Id);
	
	/**
	 * Update User By ID
	 * @param idToUpdate
	 * @param updateUser
	 * @return updates a user by its id 
	 */
	public T updateOne(long idToUpdate, T updateUser);
}
