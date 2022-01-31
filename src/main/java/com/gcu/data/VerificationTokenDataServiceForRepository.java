//package com.gcu.data;
//
//import java.sql.Timestamp;
//import java.util.Calendar;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.gcu.model.UserEntity;
//import com.gcu.model.VerificationToken;
//
//@Service
//public class VerificationTokenDataServiceForRepository 
//{
//	private final VerificationTokenRepository verificationTokenRepository;
//	
//	@Autowired
//	public VerificationTokenDataServiceForRepository(VerificationTokenRepository verificationTokenRepository)
//	{
//		this.verificationTokenRepository = verificationTokenRepository;
//	}
//	
//	@Transactional
//	public VerificationToken findByToken(String token)
//	{
//		return verificationTokenRepository.findByToken(token);
//	}
//	
//	@Transactional
//	public VerificationToken findByUser(UserEntity user)
//	{
//		return verificationTokenRepository.findByUser(user);
//	}
//	
//	@Transactional
//	public void save(UserEntity user, String token)
//	{
//		VerificationToken verificationToken = new VerificationToken(token, user);
//		
//		// Set expiry date to 24hrs
//		verificationToken.setExpiryDate(calculateExpiryDate(24*60));
//		verificationTokenRepository.save(verificationToken);
//	}
//	
//	// Calculate expiry date
//	private Timestamp calculateExpiryDate(int expiryTimeInMinutes)
//	{
//		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.MINUTE, expiryTimeInMinutes);
//		return new Timestamp(cal.getTime().getTime());
//	}
//}
