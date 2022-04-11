package com.gcu.business;

import java.util.List;

import com.gcu.model.PostModel;

public interface IPostBusinessService
{
	/**
	 * Get Post By ID
	 * @param Id
	 * @return post by its id
	 */
	public PostModel getById(int Id);
	
	/**
	 * Get List of Posts
	 * @return a list of posts in database
	 */
	public List<PostModel> getPosts();
	
	/**
	 * Get List of Posts with searchTerm
	 * @param searchTerm
	 * @return a list of posts in database based on the searchTerm
	 */
	public List<PostModel> searchPosts(String searchTerm);
	
	/**
	 * Add a Post
	 * @param newPost
	 * @return a post created by the user
	 */
	public int addOne(PostModel newPost);
	
	/**
	 * Delete Post By ID
	 * @param id
	 * @return deletes a post by its id
	 */
	public boolean deleteOne(long id);
	
	/**
	 * Update Post By ID
	 * @param idToUpdate
	 * @param updatePost
	 * @return updates a post by its id
	 */
	public PostModel updateOne(long idToUpdate, PostModel updatePost);
	
	/**
	 * Get List of Posts By UserID
	 * @param id
	 * @return a list of posts specific to the user id
	 */
	public List<PostModel> getAllPostsByUser(long id);
}
