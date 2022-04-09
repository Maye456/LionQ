package com.gcu.data;

import java.util.List;

import org.springframework.stereotype.Service;

public interface IUserDataAccess<T>
{ 
	public int createUser(T newUser);
	public T findByUsername(String username);
	public List<T> getUsers();
	public List<T> searchUsers(String searchTerm);
	public boolean deleteOne(long id);
	public T getByID(int Id);
	public T updateOne(long idToUpdate, T updateUser);
}
