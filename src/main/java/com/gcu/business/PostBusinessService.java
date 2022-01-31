package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.PostDataServiceForRepository;
import com.gcu.model.PostEntity;
import com.gcu.model.PostModel;

@Service
public class PostBusinessService implements IPostBusinessService
{
	@Autowired
	PostDataServiceForRepository service;
	
	@Autowired
	UserBusinessService userService;

	@Override
	public PostModel getById(int Id)
	{
		PostEntity result = service.getByID(Id);
		PostModel post = new PostModel(
				result.getPost_id(),
				result.getTitle(),
				result.getContent(),
				result.getTime_posted(),
				result.getTime_updated(),
				result.getPost_userId()
				);
		return post;
	}

	@Override
	public List<PostModel> getPosts()
	{
		// Fetch the list of entities
		List<PostEntity> postsE = service.getPosts();
		// Create an empty list of posts
		List<PostModel> posts = new ArrayList<PostModel>();
		// For each entity in the list, create a new order and add to orders
		for (PostEntity entity: postsE)
		{
			// Translate from Entity to Post Model
			PostModel post = new PostModel(
					entity.getPost_id(),
					entity.getTitle(),
					entity.getContent(),
					entity.getTime_posted(),
					entity.getTime_updated(),
					entity.getPost_userId());
			post.setUser(userService.getCurrentUser());
			System.out.println(post.getUser().getUsername());
			posts.add(post);	
		}
		return posts;
	}

	@Override
	public List<PostModel> searchPosts(String searchTerm)
	{
		List<PostEntity> postsE = service.searchPosts(searchTerm);
        List<PostModel> posts = new ArrayList<PostModel>();
        for (PostEntity entity: postsE)
		{
			// Translate from Entity to Post Model
			PostModel post = new PostModel(
					entity.getPost_id(),
					entity.getTitle(),
					entity.getContent(),
					entity.getTime_posted(),
					entity.getTime_updated(),
					entity.getPost_userId());
			post.setUser(userService.getCurrentUser());
			System.out.println(post.getUser().getUsername());
			posts.add(post);	
		}
		return posts;
	}

	@Override
	public int addOne(PostModel newPost)
	{
		PostEntity entity = new PostEntity(
				newPost.getPost_id(),
				newPost.getTitle(),
				newPost.getContent()
				);
		return service.addOne(entity);
	}

	@Override
	public boolean deleteOne(long id)
	{
		return service.deleteOne(id);
	}

	@Override
	public PostModel updateOne(long idToUpdate, PostModel updatePost)
	{
		PostEntity entity = new PostEntity(
				updatePost.getPost_id(),
				updatePost.getTitle(),
				updatePost.getContent(),
				updatePost.getTime_posted(),
				updatePost.getTime_updated(),
				updatePost.getPost_userId()
                );
		PostEntity result = service.updateOne(idToUpdate, entity);
        
        PostModel updated = new PostModel(
        		result.getPost_id(),
				result.getTitle(),
				result.getContent(),
				result.getTime_posted(),
				result.getTime_updated(),
				result.getPost_userId()
                );
        return updated;
	}
}
