/*
 *	Jeanna Maye Benitez
 *	March 10, 2022
 *	Description: Executes CRUD operations using PostEntity as the object and jdbc
 */

package com.gcu.data;

import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.model.PostEntity;
import com.gcu.model.UserModel;

@Service
public class PostDataServiceForRepository implements IPostDataAccess<PostEntity>
{
	@Autowired
	private PostRepository postRepository;
	@SuppressWarnings("unused")
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	// Non-Default Constructor
	public PostDataServiceForRepository(PostRepository postRepository, DataSource dataSource)
	{
		this.postRepository = postRepository;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public PostEntity getByID(int Id)
	{
		return postRepository.findById((long) Id).orElse(null);
	}

	@Override
	public List<PostEntity> getPosts()
	{
		List<PostEntity> posts = (List<PostEntity>) postRepository.findAll();
		return posts;
	}

	@Override
	public List<PostEntity> searchPosts(String searchTerm)
	{
		List<PostEntity> result = postRepository.findByTitleContainingIgnoreCase(searchTerm);
		return result;
	}

	@Override
	public int addOne(PostEntity newPost)
	{
		PostEntity result = postRepository.save(newPost);
		if (result == null)
		{
			return 0;
		}
		return (int) result.getPost_id();
	}

	@Override
	public boolean deleteOne(long id)
	{
		postRepository.deleteById(id);
		return true;  
	}

	@Override
	public PostEntity updateOne(long idToUpdate, PostEntity updatePost)
	{
		System.out.println("=====PostDataServiceForRepository POST ID:: {" + updatePost.getPost_id() + "}");
		
		PostEntity result = postRepository.save(updatePost);
		return result;
	}

	@Override
	public List<PostEntity> getAllPostsByUser(long id)
	{
		List<PostEntity> posts = postRepository.findAllByUserid(id);
		return posts;
	}
}