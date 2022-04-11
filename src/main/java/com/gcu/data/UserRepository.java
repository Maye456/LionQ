package com.gcu.data;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gcu.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>
{
	/**
	 * Gets Username of the User (Ignores Case)
	 * @param searchTerm
	 * @return a user by its username
	 */
	List<UserEntity> findByUsernameContainingIgnoreCase(String searchTerm);

	/**
	 * Gets a User by Email
	 * @param email
	 * @return a user by its email
	 */
	Optional<UserEntity> findUserByEmail(String email);
	
	/**
	 * Get User By Username
	 * @param username
	 * @return a user by its username
	 */
	UserEntity findByUsername(String username);
	
	/**
	 * Gets User By ID
	 * @param user_id
	 * @return a user by its id
	 */
	UserEntity findById(int user_id);
	
	/**
	 * Gets All Users that are Active
	 * @param active
	 * @return a list of users that are active
	 */
    List<UserEntity> findByActive(long active);
}
 