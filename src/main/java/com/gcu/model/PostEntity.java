package com.gcu.model;

import java.time.Instant;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("post")
public class PostEntity
{
	@Id
	@Column("post_id")
	long post_id;
	
	@Column("title")
	String title;
	
	@Column("content")
	String content;
	
	@Column("time_posted")
	Date time_posted = Date.from(Instant.now());
	
	@Column("time_updated")
	Date time_updated;
	
	@Column("post_userId")
	long post_userId;

	public PostEntity(long post_id, String title, String content, Date time_posted, Date time_updated, long post_userId)
	{
		super();
		this.post_id = post_id;
		this.title = title;
		this.content = content;
		this.time_posted = time_posted;
		this.time_updated = time_updated;
		this.post_userId = post_userId;
	}

	public PostEntity(long post_id, String title, String content)
	{
		this.post_id = post_id;
		this.title = title;
		this.content = content;
	}
	
	public PostEntity(long post_id, String title, String content, Date time_posted)
	{
		this.post_id = post_id;
		this.title = title;
		this.content = content;
		this.time_posted = time_posted;
	}
	
	public PostEntity() {}
	
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
}