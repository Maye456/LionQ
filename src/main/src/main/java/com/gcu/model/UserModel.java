package com.gcu.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserModel 
{
	private long id; 
	
	@NotBlank(message="This is a required field")
	private String firstName;
	
	@NotBlank(message="This is a required field")
	private String lastName;
	
	@NotBlank(message="This is a required field")
	@Email(message="Please enter a valid email address")
	private String email;
	
	@NotBlank(message="This is a required field")
	@Size(min=8, message="Username must be at least 8 characters long")
	private String username;
	
	@NotBlank(message="This is a required field")
	//@Size(min=8, message="Password must be at least 8 characters long")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", message="Password must cantain one number (1-9), one lowercase letter, one uppercase letter, a special character (!@#&$), and must be between 8-20 characters long")
	private String password;
	
	@NotBlank(message="This is a required field")
	private String rpassword;
	
	private String role;
	
	public UserModel() {};
	
	public UserModel(long id, @NotBlank(message = "This is a required field") String firstName,
			@NotBlank(message = "This is a required field") String lastName,
			@NotBlank(message = "This is a required field") @Email(message = "Please enter a valid email address") String email,
			@NotBlank(message = "This is a required field") @Size(min = 8, message = "Username must be at least 8 characters long") String username,
			@NotBlank(message = "This is a required field") @Size(min = 8, message = "Password must be at least 8 characters long") @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", message="Password must cantain one number (1-9), one lowercase letter, one uppercase letter, a special character (!@#&$), and must be between 8-20 characters long") String password, String role) 
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	// Used for Login
	public UserModel(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	
	public UserModel(UserEntity user)
	{
		this.id = user.getId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.username = user.getUsername();
		this.password = user.getPassword();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRpassword() {
		return rpassword;
	}

	public void setRpassword(String rpassword) {
		this.rpassword = rpassword;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString()
	{
		return "RegisterModel [First Name=" + firstName + ", Last Name=" + lastName + ", Username=" + username + ", Email=" + email + ", Password=" + password + "]";
	}
}
