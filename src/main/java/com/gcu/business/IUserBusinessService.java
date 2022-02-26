package com.gcu.business;

import java.util.List;

import com.gcu.model.PostModel;
import com.gcu.model.UserModel;

public interface IUserBusinessService 
{
	public int createUser(UserModel newUser);
	public List<UserModel> getUsers();
	public List<UserModel> searchUsers(String searchTerm);
	public boolean deleteOne(long id);
	public UserModel updateOne(long idToUpdate, UserModel updateUser);
	public UserModel getById(int Id);
}
