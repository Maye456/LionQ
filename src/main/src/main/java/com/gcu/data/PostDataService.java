/*
 *	Jeanna Maye Benitez
 *	March 10, 2022
 *	Description: Executes CRUD operations with SQL statements connecting to the database
 */

package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gcu.model.PostEntity;
import com.gcu.model.PostMapper;
import com.gcu.model.PostModel;

public class PostDataService implements IPostDataAccess<PostModel>
{
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	DataSource dataSource;
	JdbcTemplate jdbcTemplate;
	
	public PostDataService(DataSource dataSource)
	{
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public PostModel getByID(int Id)
	{
		PostModel result = jdbcTemplate.queryForObject(
				"SELECT * FROM post WHERE post_id = ?",
				new PostMapper(),
				new Object[] {Id});
		return result;
	}

	@Override
	public List<PostModel> getPosts()
	{
		return jdbcTemplate.query(
				"SELECT * FROM post",
				new PostMapper());
	}

	@Override
	public List<PostModel> searchPosts(String searchTerm)
	{
		return jdbcTemplate.query(
				"SELECT * FROM post WHERE title LIKE ?",
				new PostMapper(),
				new Object[] {"%" + searchTerm + "%"});
	}

	@Override
	public int addOne(PostModel newPost)
	{
		return jdbcTemplate.update(
				"INSERT INTO post (title, content, user_Id) VALUES (?, ?, ?)",
				newPost.getTitle(),
				newPost.getContent(),
				newPost.getUser_id());
	}

	@Override
	public boolean deleteOne(long id)
	{
		int updateResult = jdbcTemplate.update(
				"DELETE FROM post WHERE post_id = ?",
				new Object[] {id});
		return (updateResult > 0);
	}

	@Override
	public PostModel updateOne(long idToUpdate, PostModel updatePost)
	{
		int result = jdbcTemplate.update(
				"UPDATE post SET title = ?, content = ? WHERE post_id = ?",
				updatePost.getTitle(),
				updatePost.getContent(),
				idToUpdate);
		if (result > 0)
		{
			return updatePost;
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<PostModel> getAllPostsByUser(long id)
	{
		return jdbcTemplate.query(
				"SELECT * FROM post where user_Id = ?",
				new PostMapper(),
				new Object[] {id});
	}
}
