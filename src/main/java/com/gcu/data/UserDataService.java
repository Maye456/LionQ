package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.gcu.model.UserModel;
import com.gcu.model.PostMapper;
import com.gcu.model.PostModel;
import com.gcu.model.UserMapper;

@Service
public class UserDataService implements IUserDataAccess<UserModel>
{
	@Autowired
	DataSource dataSource;
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	private UserRepository userRepository;
	
	public UserDataService(DataSource dataSource)
	{
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int createUser(UserModel newUser) 
	{		
		return jdbcTemplate.update(
				"INSERT INTO user (FirstName, LastName, Email, Username, Password) VALUES (?, ?, ?, ?, ?)",
				newUser.getFirstName(),
				newUser.getLastName(),
				newUser.getEmail(),
				newUser.getUsername(),
				newUser.getPassword()
				);
	}

	@Override
	public UserModel findByUsername(String username) 
	{
		UserModel result = jdbcTemplate.queryForObject(
				"SELECT * FROM user WHERE Username = ?",
				new UserMapper(),
				new Object[] {username});
		return result;
	}

	@Override
	public List<UserModel> getUsers()
	{
		return jdbcTemplate.query(
				"SELECT (Firstname, Lastname, Email, Username, Role) FROM user",
				new UserMapper());
	}

	@Override
	public List<UserModel> searchUsers(String searchTerm)
	{
		return jdbcTemplate.query(
				"SELECT * FROM post WHERE Username LIKE ?",
				new UserMapper(),
				new Object[] {"%" + searchTerm + "%"});
	}

	@Override
	public boolean deleteOne(long id)
	{
		int updateResult = jdbcTemplate.update(
				"DELETE FROM user WHERE user_Id = ?",
				new Object[] {id});
		return (updateResult > 0);
	}

	@Override
	public UserModel getByID(int Id)
	{
		UserModel result = jdbcTemplate.queryForObject(
				"SELECT * FROM user WHERE user_Id = ?",
				new UserMapper(),
				new Object[] {Id});
		return result;
	}

	@Override
	public UserModel updateOne(long idToUpdate, UserModel updateUser)
	{
		int result = jdbcTemplate.update(
				"UPDATE user SET Firstname = ?, Lastname = ?, Email = ?, Username = ?, Password = ?, Role = ? WHERE user_Id = ?",
				updateUser.getFirstName(),
				updateUser.getLastName(),
				updateUser.getEmail(),
				updateUser.getUsername(),
				updateUser.getPassword(),
				updateUser.getRole(),
				idToUpdate);
		if (result > 0)
		{
			return updateUser;
		}
		else
		{
			return null;
		}
	}
}
