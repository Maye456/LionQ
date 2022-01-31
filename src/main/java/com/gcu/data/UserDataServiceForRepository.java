package com.gcu.data;

import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gcu.model.UserModel;
import com.gcu.model.PostEntity;
import com.gcu.model.UserEntity;
import com.gcu.model.UserMapper;

@Service
public class UserDataServiceForRepository implements IUserDataAccess<UserEntity>
{
	@Autowired
	private UserRepository userRepository;
	@SuppressWarnings("unused")
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	// Non-Default Constructor
	public UserDataServiceForRepository(UserRepository userRepository, DataSource dataSource)
	{
		this.userRepository = userRepository;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Transactional
	public UserEntity save(UserEntity user)
	{
		return userRepository.save(user);
	}
	
	@Override
	public int createUser(UserEntity newUser)
	{
		//UserEntity user = new UserEntity();
		UserEntity result = userRepository.save(newUser);
        if (result == null)
        {
            return 0;
        }
        return (int) result.getId();
	} 
	
	@Transactional
	public Optional<UserEntity> findUserByEmail(String email)
	{
		return userRepository.findUserByEmail(email);
	}
	
	public boolean userExists(String email)
	{
		return findUserByEmail(email).isPresent();
	}

	@Override
	public UserEntity findByUsername(String username)
	{
		return userRepository.findByUsername(username);
	}
	
	@Override
	public List<UserEntity> getUsers()
	{
		List<UserEntity> users = (List<UserEntity>) userRepository.findAll();
		return users;
	}

	@Override
	public List<UserEntity> searchUsers(String searchTerm)
	{
		List<UserEntity> result = userRepository.findByUsernameContainingIgnoreCase(searchTerm);
		return result;
	}
}
