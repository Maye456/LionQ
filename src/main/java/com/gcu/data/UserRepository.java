package com.gcu.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.gcu.model.UserEntity;
import com.gcu.model.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>
{
	List<UserEntity> findByUsernameContainingIgnoreCase(String searchTerm);

	Optional<UserEntity> findUserByEmail(String email);
	
	UserEntity findByUsername(String username);
}
