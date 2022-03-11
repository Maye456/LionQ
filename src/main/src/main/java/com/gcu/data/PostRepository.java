/*
 *	Jeanna Maye Benitez
 *	March 10, 2022
 *	Description: To find a post by title and find all the posts by user id and uses the crudrepository
 */

package com.gcu.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gcu.model.PostEntity;

public interface PostRepository extends CrudRepository<PostEntity, Long>
{
	List<PostEntity> findByTitleContainingIgnoreCase(String searchTerm);

	List<PostEntity> findAllByUserid(long user_id);
}
