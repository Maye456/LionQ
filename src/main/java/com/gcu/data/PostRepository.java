package com.gcu.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gcu.model.PostEntity;

public interface PostRepository extends CrudRepository<PostEntity, Long>
{
	/**
	 * Gets Title of the Post (Ignores Case)
	 * @param searchTerm
	 * @return a post by its title
	 */
	List<PostEntity> findByTitleContainingIgnoreCase(String searchTerm);

	/**
	 * Gets all Posts by the UserID
	 * @param user_id
	 * @return a list of posts by the user id
	 */
	List<PostEntity> findAllByUserid(long user_id);
}
