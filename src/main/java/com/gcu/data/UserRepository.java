package com.gcu.data;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gcu.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>
{
	List<UserEntity> findByUsernameContainingIgnoreCase(String searchTerm);

	Optional<UserEntity> findUserByEmail(String email);
	
	UserEntity findByUsername(String username);
	
	UserEntity findById(int user_id);
	
    List<UserEntity> findByActive(long active);
}
 