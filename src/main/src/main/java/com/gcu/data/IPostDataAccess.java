/*
 *	Jeanna Maye Benitez
 *	March 10, 2022
 *	Description: Interface class for PostDataServiceForRepository & PostDataService that includes
 *					CRUD operations
 */

package com.gcu.data;

import java.util.List;

import com.gcu.model.UserModel;

public interface IPostDataAccess<T>
{
	public T getByID(int Id);
	public List<T> getPosts();
	public List<T> searchPosts(String searchTerm);
	public int addOne(T newPost);
	public boolean deleteOne(long id);
	public T updateOne(long idToUpdate, T updatePost);
	public List<T> getAllPostsByUser(long id);
}
