package com.gcu.model;

import java.time.Instant;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PostModel 
{
	private long post_id;
	
	@NotBlank(message="This is a required field")
	@Size(min=8, max=250)
	private String title;
	
	@NotBlank(message="This is a required field")
	@Size(min=8, max=800)
	private String content;
	
	@NotNull
	private Date time_posted = Date.from(Instant.now());
	
	private Date time_updated;
	
	@NotNull
	private long post_userId;
	
	public UserModel user;
	
	public PostModel(long post_id, @NotBlank(message="This is a required field") @Size(max = 250) String title, @NotBlank(message="This is a required field") @Size(max = 800) String content,
			@NotNull Date time_posted, Date time_updated, @NotNull long post_userId)
	{
		this.post_id = post_id;
		this.title = title;
		this.content = content;
		this.time_posted = time_posted;
		this.time_updated = time_updated;
		this.post_userId = post_userId;
	}

	public PostModel(long post_id, @NotBlank(message="This is a required field") @Size(max = 250) String title, @NotBlank(message="This is a required field") @Size(max = 800) String content)
	{
		this.post_id = post_id;
		this.title = title;
		this.content = content;
	}
	
	public PostModel(UserModel user) 
	{
		this.user = user;
	}
	
	public PostModel(@NotBlank(message="This is a required field") @Size(max = 250) String title, @NotBlank(message="This is a required field") @Size(max = 800) String content)
	{
		this.title = title;
		this.content = content;
	}
	
	public PostModel() {}

	public long getPost_id()
	{
		return post_id;
	}

	public void setPost_id(long post_id)
	{
		this.post_id = post_id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public Date getTime_posted()
	{
		return time_posted;
	}

	public void setTime_posted(Date time_posted)
	{
		this.time_posted = time_posted;
	}

	public Date getTime_updated()
	{
		return time_updated;
	}

	public void setTime_updated(Date time_updated)
	{
		this.time_updated = time_updated;
	}

	public long getPost_userId()
	{
		return post_userId;
	}

	public void setPost_userId(long post_userId)
	{
		this.post_userId = post_userId;
	}

	public UserModel getUser()
	{
		return user;
	}

	public void setUser(UserModel user)
	{
		this.user = user;
	}
}