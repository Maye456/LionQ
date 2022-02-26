package com.gcu.business;

import java.util.List;

import com.gcu.model.PostModel;

public interface IPostBusinessService
{
	public PostModel getById(int Id);
	public List<PostModel> getPosts();
	public List<PostModel> searchPosts(String searchTerm);
	public int addOne(PostModel newPost);
	public boolean deleteOne(long id);
	public PostModel updateOne(long idToUpdate, PostModel updatePost);
	public List<PostModel> getAllPostsByUser(long id);
}
