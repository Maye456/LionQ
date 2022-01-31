package com.gcu.data;

import java.util.List;

public interface IPostDataAccess<T>
{
	public T getByID(int Id);
	public List<T> getPosts();
	public List<T> searchPosts(String searchTerm);
	public int addOne(T newPost);
	public boolean deleteOne(long id);
	public T updateOne(long idToUpdate, T updatePost);
}
