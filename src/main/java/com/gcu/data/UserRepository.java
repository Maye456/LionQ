package com.gcu.data;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.gcu.model.UserEntity;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long>
{
	List<UserEntity> findByUsernameContainingIgnoreCase(String searchTerm);

	Optional<UserEntity> findUserByEmail(String email);
	
	UserEntity findByUsername(String username);
}
