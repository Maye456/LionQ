//package com.gcu.model;
//
//
//import java.sql.Timestamp;
//import javax.persistence.CascadeType;
//import javax.persistence.*;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.relational.core.mapping.Column;
//import org.springframework.data.relational.core.mapping.Table;
//
//@Entity
//@Table("verification_token")
//public class VerificationToken 
//{
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
//	
//	private String token;
//	
//	@Column("expiry_date")
//	private Timestamp expiryDate;
//	
//	@OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
//	@JoinColumn(name = "user_id", referencedColumnName = "id")
//	private UserEntity user;
//	
//	public VerificationToken() {}
//
//	public VerificationToken(String token, UserEntity user) {
//		this.token = token;
//		this.user = user;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getToken() {
//		return token;
//	}
//
//	public void setToken(String token) {
//		this.token = token;
//	}
//
//	public Timestamp getExpiryDate() {
//		return expiryDate;
//	}
//
//	public void setExpiryDate(Timestamp expiryDate) {
//		this.expiryDate = expiryDate;
//	}
//
//	public UserEntity getUser() {
//		return user;
//	}
//
//	public void setUser(UserEntity user) {
//		this.user = user;
//	};
//}
