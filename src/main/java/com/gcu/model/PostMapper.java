package com.gcu.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PostMapper implements RowMapper<PostModel>
{
	/* Match property names in PostModel w/ the column names in the db 
	 Class				
	 Properties
	 ======================================
	 post_id			post_id
	 title				title
	 content			content
	 time_posted		time_posted
	 time_updated		time_updated
	 post_userId		post_userId
	 */
	
	public PostModel mapRow(ResultSet rs, int i) throws SQLException
	{
		PostModel post = new PostModel(
				rs.getInt("post_id"),
				rs.getString("title"),
				rs.getString("content"),
				rs.getDate("time_posted"),
				rs.getDate("time_updated"),
				rs.getInt("user_id")
				);
		return post;
	}
}
