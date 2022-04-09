package com.gcu.data;

import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gcu.model.UserModel;
import com.gcu.model.PostEntity;
import com.gcu.model.UserEntity;
import com.gcu.model.UserMapper;

@Service()
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
	
	// FOR SORTING
	public Page<UserEntity> findPaginated(final int pageNumber, final int pageSize,
            final String sortField, final String sortDirection)
	{
		final Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
				Sort.by(sortField).ascending() : Sort.by(sortField).descending();
		final Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);
		return userRepository.findAll(pageable);
		
	}

	@Override
	public List<UserEntity> searchUsers(String searchTerm)
	{
		List<UserEntity> result = userRepository.findByUsernameContainingIgnoreCase(searchTerm);
		return result;
	}

	@Override
	public boolean deleteOne(long id)
	{
		userRepository.deleteById(id);
		return true;
	}

	@Override
	public UserEntity getByID(int Id)
	{
		return userRepository.findById((long) Id).orElse(null);
	}

	@Override
	public UserEntity updateOne(long idToUpdate, UserEntity updateUser)
	{
		UserEntity result = userRepository.save(updateUser);
		return result;
	}
	
	public UserEntity findById(int user_id)
	{
        return userRepository.findById(user_id);
    }

    public UserEntity saveUser(UserEntity user)
    {
        user.setActive(1);
        return userRepository.save(user);
    }

    public UserEntity updateUserActiveState(int user_id, long active) 
    {
    	UserEntity user = userRepository.findById((long) user_id).orElse(null);
        user.setActive(active);
        return userRepository.save(user);
    }

    public List<UserEntity> getActiveUserList()
    {
        return userRepository.findByActive(1);
    }
}
